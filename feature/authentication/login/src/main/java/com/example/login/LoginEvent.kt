package com.example.login

sealed interface LoginEvent {
    data class EmailChanged(val value: String) : LoginEvent
    data class PasswordChanged(val value: String) : LoginEvent
    data class RememberMeChanged(val value: Boolean) : LoginEvent
    data object Submit : LoginEvent
    data object ForgotPasswordClick : LoginEvent
    data object SignUpClick : LoginEvent
    data object GoogleClick : LoginEvent
}