package com.example.register.utils

sealed interface RegisterEvent {
    data class NameChanged(val value: String) : RegisterEvent
    data class EmailChanged(val value: String) : RegisterEvent
    data class PasswordChanged(val value: String) : RegisterEvent
    data class ConfirmChanged(val value: String) : RegisterEvent
    data object Submit : RegisterEvent
    data object SignInClick : RegisterEvent
}