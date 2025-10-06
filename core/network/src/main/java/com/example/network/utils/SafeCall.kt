package com.example.network.utils

import kotlinx.serialization.SerializationException
import retrofit2.HttpException
import java.io.IOException

suspend inline fun safeApiCall(crossinline block: suspend () -> Unit) = try {
    Result.Success(block())
} catch (e: IOException) {
    Result.Error(AdsError.Network)
} catch (e: HttpException) {
    Result.Error(AdsError.Http(e.code(), e.message()))
} catch (e: SerializationException) {
    Result.Error(AdsError.Parse(e))
} catch (t: Throwable) {
    Result.Error(AdsError.Unknown(t))
}