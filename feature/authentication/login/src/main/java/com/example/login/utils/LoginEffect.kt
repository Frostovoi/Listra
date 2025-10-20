package com.example.login.utils

sealed interface LoginEffect{
    data object StartGoogleSignIn : LoginEffect
    data class ShowMessage(val text: String) : LoginEffect
    data object OpenSignUp : LoginEffect
    data object OpenForgot : LoginEffect
}