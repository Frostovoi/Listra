package com.example.auth_repo.dto

import com.example.api.models.UserSession
import kotlinx.serialization.Serializable

@Serializable
data class SessionDto(
    val userId: String,
    val email: String,
    val accessToken: String,
    val refreshToken: String
) {
    fun toDomain() = UserSession(userId, email, accessToken, refreshToken)
}
