package com.example.reset.utils

sealed interface ResetEffect {
    data class ShowMessage(val text: String) : ResetEffect
    data object NavigateBack : ResetEffect
    data object NavigateSignIn : ResetEffect
}