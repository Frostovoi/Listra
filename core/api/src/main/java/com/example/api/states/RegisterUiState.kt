package com.example.api.states

data class RegisterUiState(
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    val confirm: String = "",

    val emailError: String? = null,
    val passwordError: String? = null,
    val confirmError: String? = null,
    val formError: String? = null,
    val fullNameError: String? = null,

    val isPasswordVisible: Boolean = false,
    val isConfirmVisible: Boolean = false,
    val acceptedTerms: Boolean = false,

    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false
) {
    val isEmailValid: Boolean get() = EMAIL_REGEX.matches(email.trim())
    val isPasswordValid: Boolean get() = password.length >= 8 && password.any { it.isDigit() } && password.any { it.isUpperCase() }
    val isNameValid: Boolean get() = fullName.trim().length >= 2
    val isPasswordsMatch: Boolean get() = password == confirm && confirm.isNotEmpty()
    val canSubmit: Boolean get() =
        !isLoading && isNameValid && isEmailValid && isPasswordValid && isPasswordsMatch && acceptedTerms

    companion object {
        private val EMAIL_REGEX = """^([a-zA-Z0-9_\.+-])+@([a-zA-Z0-9-]+\.)+[a-zA-Z]{2,}$""".toRegex()
    }
}