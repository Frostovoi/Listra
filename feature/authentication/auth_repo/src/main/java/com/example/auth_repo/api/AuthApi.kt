package com.example.auth_repo.api

import com.example.auth_repo.dto.SessionDto
import com.example.auth_repo.requests.GoogleLoginRequest
import com.example.auth_repo.requests.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("auth/login")
    suspend fun login(@Body req: LoginRequest): SessionDto

    @POST("auth/google")
    suspend fun loginGoogle(@Body req: GoogleLoginRequest): SessionDto
}