package com.example.coopbank.repository
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coopbank.data.Resource
import com.example.coopbank.models.Profile
import com.example.coopbank.network.AuthApi
import com.example.coopbank.storage.LoginDatabase
import com.example.coopbank.storage.daos.ProfileDao
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: AuthApi, db: LoginDatabase, application: Application){
    private val profileDao: ProfileDao
    private val context: Context

    init {
        context=application.applicationContext
        profileDao=db.profileDao()
    }
    suspend fun loginMember(username: String, password: String): Resource<Profile> {
        return try {
            Resource.Loading(data = true)
            val loginJson = """
    {
        "username": "${username}",
        "password": "${password}"
    }
""".trimIndent()
            val requestBody = loginJson.toRequestBody("application/json".toMediaType())

            val response = api.loginMember(requestBody)
            Resource.Loading(data = false)

            run {
                Log.d("Response", "ProfileData: $response")
                Resource.Success(data = response)
            }
        } catch (exception: Exception) {
            Log.d("ErrorResponse", "Error: ${exception.message.toString()}")
            Resource.Error(message = exception.message.toString())
        }
    }
    @OptIn(DelicateCoroutinesApi::class)
    fun saveProfile(data: Profile) {
        GlobalScope.launch(context = Dispatchers.IO) {
            profileDao.delete()
            data.let { profileDao.insertProfile(it) }
        }
    }

    fun getProfile(): LiveData<Resource<Profile>> {
        val resultLiveData = MutableLiveData<Resource<Profile>>()
        resultLiveData.value = Resource.Loading()

        try {
            val profileLiveData = profileDao.getProfile()
            profileLiveData.observeForever { profile ->
                profile?.let {
                    resultLiveData.value = Resource.Success(profile)
                } ?: run {
                    resultLiveData.value = Resource.Error("Profile not found")
                }
            }
        } catch (exception: Exception) {
            resultLiveData.value = Resource.Error("Error: ${exception.message}")
        }

        return resultLiveData
    }






}