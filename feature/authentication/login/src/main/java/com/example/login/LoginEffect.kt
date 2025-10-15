package com.example.login

sealed interface LoginEffect{
    data object StartGoogleSignIn : LoginEffect
    data class ShowMessage(val text: String) : LoginEffect
}