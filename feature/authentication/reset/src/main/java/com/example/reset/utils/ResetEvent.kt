package com.example.reset.utils

sealed interface ResetEvent{
    data class EmailChanged(val value: String) : ResetEvent
    data object Submit : ResetEvent
    data object BackClick : ResetEvent
    data object SignInClick : ResetEvent
}