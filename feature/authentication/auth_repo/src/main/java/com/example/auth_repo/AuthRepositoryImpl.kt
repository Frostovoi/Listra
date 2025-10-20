package com.example.auth_repo

import com.example.api.models.UserSession
import com.example.api.repository.AuthRepository
import com.example.auth_repo.api.AuthApi
import com.example.auth_repo.requests.GoogleLoginRequest
import com.example.auth_repo.requests.LoginRequest
import com.example.api.utils.Result
import com.example.api.utils.runOperationCatching
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(val api: AuthApi) : AuthRepository {

    override suspend fun signIn(
        email: String,
        password: String
    ): Result<UserSession, Throwable> {
        return runOperationCatching {
            api.login(LoginRequest(email, password)).toDomain()
        }
    }

    override suspend fun signInWithGoogle(idToken: String): Result<UserSession, Throwable> {
        return runOperationCatching {
            api.loginGoogle(GoogleLoginRequest(idToken)).toDomain()
        }
    }

    override suspend fun signOut(): Result<Unit, Throwable> {
        TODO("Not yet implemented")
    }

    override suspend fun signUp(
        email: String,
        password: String,
        fullName: String
    ): Result<Unit, Throwable> {
        TODO("Not yet implemented")
    }

    override suspend fun resetPassword(email: String): Result<Unit, Throwable> {
        TODO("Not yet implemented")
    }


}