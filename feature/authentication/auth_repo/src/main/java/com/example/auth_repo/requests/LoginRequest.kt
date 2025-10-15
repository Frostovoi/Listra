package com.example.auth_repo.requests

data class LoginRequest(
    val email: String,
    val password: String
)