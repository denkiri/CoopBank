package com.example.coopbank.storage
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coopbank.models.Profile
import com.example.coopbank.storage.daos.ProfileDao
import javax.inject.Singleton

@Singleton
@Database(entities = [Profile::class],version = 1,exportSchema = false)
 abstract class LoginDatabase :RoomDatabase() {
    abstract fun profileDao(): ProfileDao
 }
