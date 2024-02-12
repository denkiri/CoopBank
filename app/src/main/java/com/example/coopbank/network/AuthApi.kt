package com.example.coopbank.network
import com.example.coopbank.models.Profile
import com.example.loginapp.models.ProfileData
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton
@Singleton
interface AuthApi {
    @GET("login")
    suspend fun loginMember(
        @Query("username") username: String,
        @Query("password") password: String
    ): Profile

}