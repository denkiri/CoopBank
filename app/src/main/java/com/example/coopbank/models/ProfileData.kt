package com.example.loginapp.models

import com.example.coopbank.models.Profile

data class ProfileData(
    val error: Boolean,
    val message: String,
    val profile: Profile,
    val status: Int,
    val token: String
)