package com.example.network.utils

sealed class Result <out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val exception: AdsError) : Result<Nothing>()
}

inline fun <T, R> Result<T>.map(transform: (T) -> R): Result<R> = when (this) {
    is Result.Success -> Result.Success(transform(data))
    is Result.Error -> this
}


fun <T> Result<List<T>>.toAdsList(): List<T> =
    when (this) {
        is Result.Success -> data
        is Result.Error -> emptyList()
    }