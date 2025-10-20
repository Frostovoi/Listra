package com.example.login

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.states.LoginUiState
import com.example.api.repository.AuthRepository
import com.example.api.utils.doOnError
import com.example.api.utils.doOnSuccess
import com.example.login.utils.LoginEffect
import com.example.login.utils.LoginEvent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import com.example.login.utils.LoginScreenDefaults as LSD
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState>
        get() = _uiState.asStateFlow()

    private val _effects = MutableSharedFlow<LoginEffect>()
    val effects: SharedFlow<LoginEffect>
        get() = _effects.asSharedFlow()

    private val handler = CoroutineExceptionHandler { _, e ->
        viewModelScope.launch { _effects.emit(
            value = LoginEffect.ShowMessage(e.message ?: LSD.UNEXPECTED_ERROR_TEXT))
        }
    }


    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChanged -> _uiState.update {
                it.copy(email = event.value, emailError = validateEmail(event.value))
            }
            is LoginEvent.PasswordChanged -> _uiState.update {
                it.copy(
                    password = event.value,
                    passwordError = validatePassword(event.value)
                )
            }
            is LoginEvent.RememberMeChanged -> _uiState.update { it.copy(rememberMe = event.value) }
            is LoginEvent.Submit -> submit()
            is LoginEvent.ForgotPasswordClick -> viewModelScope.launch { _effects.emit(
                value = LoginEffect.OpenForgot
            ) }
            is LoginEvent.SignUpClick -> viewModelScope.launch {
                Log.d("LoginViewModel", "onSignUp")
                _effects.emit(
                    value = LoginEffect.OpenSignUp
                )
            }
            is LoginEvent.GoogleClick -> viewModelScope.launch { _effects.emit(
                value = LoginEffect.StartGoogleSignIn
            ) }
        }

    }

    private fun submit() {
        viewModelScope.launch(handler) {
            val s = uiState.value
            val emailError = validateEmail(s.email)
            val pasError = validatePassword(s.password)
            if (emailError != null || pasError != null) {
                _uiState.update { it.copy(
                    emailError = emailError,
                    passwordError = pasError
                ) }
                return@launch
            }
            _uiState.update { it.copy(isLoading = true, formError = null) }
            val result = repository.signIn(
                email = s.email,
                password = s.password
            )
            _uiState.update { it.copy(isLoading = false)}

            result
                .doOnError {
                _effects.emit(value = LoginEffect.ShowMessage(
                    text = it.message ?: LSD.LOGIN_FAILED_TEXT
                )) }
                .doOnSuccess {
                // #TODO сделать навигацию внутрь приложения
                }


        }
    }

    private fun validateEmail(email: String): String? =
        if (email.isBlank()) {
            LSD.BLANK_EMAIL_TEXT
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            LSD.INVALID_EMAIL_TEXT
        } else null

    private fun validatePassword(pwd: String): String? =
        if (pwd.length < 8) LSD.SHORT_PASSWORD_TEXT else null


    fun onGoogleIdToken(idToken: String) {
        viewModelScope.launch(handler) {
            _uiState.update { it.copy(isLoading = true, formError = null)}
            val res = repository.signInWithGoogle(idToken)
            _uiState.update { it.copy(isLoading = false) }
            res
                .doOnSuccess {

                // #TODO навигация
            }
                .doOnError {
                    _effects.emit(
                        LoginEffect.ShowMessage(
                        it.message ?: LSD.GOOGLE_ERROR_TEXT
                    ))
                }

        }
    }

}