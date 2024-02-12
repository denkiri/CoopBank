package com.example.coopbank.models
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Profile(
    @PrimaryKey(autoGenerate = false)
    val email: String,
    val firstName: String,
    val gender: String,
    val id: Int,
    val image: String,
    val lastName: String,
    val token: String,
    val username: String
)
