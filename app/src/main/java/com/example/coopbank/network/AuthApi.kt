package com.example.coopbank.network
import com.example.coopbank.models.LoginRequest
import com.example.coopbank.models.Profile
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Singleton

@Singleton
interface AuthApi {
@POST("login")
fun loginMember(@Body loginRequest: LoginRequest): Call<Profile>
}
