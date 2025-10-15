package com.example.api.utils

sealed interface AdsError {
    data object Network: AdsError
    data class Http(val code: Int, val message: String): AdsError
    data class Parse(val cause: Throwable): AdsError
    data class Unknown(val cause: Throwable): AdsError
}