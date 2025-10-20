package com.example.api.repository

import com.example.api.models.UserSession
import com.example.api.utils.Result

interface AuthRepository {

    suspend fun signIn(email: String, password: String): Result<UserSession, Throwable>

    suspend fun signInWithGoogle(idToken: String): Result<UserSession, Throwable>

    suspend fun signOut(): Result<Unit, Throwable>

    suspend fun signUp(email: String, password: String, fullName: String): Result<Unit, Throwable>

    suspend fun resetPassword(email: String): Result<Unit, Throwable>
}