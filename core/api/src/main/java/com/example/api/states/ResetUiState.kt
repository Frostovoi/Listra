package com.example.api.states

data class ResetUiState(
    val email: String = "",
    val emailError: String? = null,
    val isSubmitting: Boolean = false,
    val isSuccess: Boolean = false,
)
