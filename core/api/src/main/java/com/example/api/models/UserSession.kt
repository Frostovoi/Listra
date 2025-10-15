package com.example.api.models

data class UserSession(
    val userId: String,
    val email: String,
    val accessToken: String,
    val refreshToken: String?
)