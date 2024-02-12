package com.example.coopbank.models
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Profile(
    @PrimaryKey(autoGenerate = false)
    val member_id: Int,
    val date_created: String,
    val email: String,
    val token: String
)