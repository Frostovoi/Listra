package com.example.register.utils

sealed interface RegisterEffect {
    data class ShowMessage(val text: String) : RegisterEffect
    data object OpenSignIn : RegisterEffect
}