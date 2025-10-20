package com.example.identity_api

import android.content.Context
import com.example.api.utils.Result

interface GoogleIdentityProvider {
    suspend fun requestIdToken(context: Context) : Result<String, Throwable>
}