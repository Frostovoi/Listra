package com.example.api.models.states


data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val rememberMe: Boolean = true,
    val isLoading: Boolean = false,
    val emailError: String? = null,
    val passwordError: String? = null,
    val formError: String? = null
)