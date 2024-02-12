package com.example.coopbank.repository
import android.app.Application
import android.content.Context
import com.example.coopbank.network.AuthApi
import com.example.coopbank.storage.LoginDatabase
import com.example.coopbank.storage.daos.ProfileDao
import javax.inject.Inject
class LoginRepository @Inject constructor(private val api: AuthApi, db: LoginDatabase, application: Application){
    private val profileDao: ProfileDao
    private val context: Context

    init {
        context=application.applicationContext
        profileDao=db.profileDao()
    }






}