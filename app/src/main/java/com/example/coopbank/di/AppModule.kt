package com.example.coopbank.di
import android.content.Context
import androidx.room.Room
import com.example.coopbank.network.AuthApi
import com.example.coopbank.storage.LoginDatabase
import com.example.coopbank.utils.Constants
import com.example.coopbank.utils.Constants.LOGIN_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideAuthApi(): AuthApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApi::class.java)
    }
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): LoginDatabase {
        return Room.databaseBuilder(
            context,
            LoginDatabase::class.java,
            LOGIN_DATABASE
        ).build()
    }
}