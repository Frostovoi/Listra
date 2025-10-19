package com.example.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.repository.AuthRepository
import com.example.api.states.RegisterUiState
import com.example.api.utils.doOnError
import com.example.api.utils.doOnSuccess
import com.example.register.utils.RegisterEffect
import com.example.register.utils.RegisterEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import com.example.register.utils.RegisterScreenDefaults as RSD
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegisterViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {

    private val _state = MutableStateFlow(RegisterUiState())
    val state: StateFlow<RegisterUiState>
        get() = _state.asStateFlow()

    private val _effects = MutableSharedFlow<RegisterEffect>()
    val effects: SharedFlow<RegisterEffect>
        get() = _effects.asSharedFlow()

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.EmailChanged -> _state.update {
                it.copy(email = event.value, error = null)
            }
            is RegisterEvent.NameChanged -> _state.update {
                it.copy(fullName = event.value, error = null)
            }
            is RegisterEvent.PasswordChanged -> _state.update {
                it.copy(password = event.value, error = null)
            }
            RegisterEvent.Submit -> submit()
            RegisterEvent.SignInClick -> viewModelScope.launch { _effects.emit(
                value = RegisterEffect.OpenSignIn
            ) }

            is RegisterEvent.ConfirmChanged -> _state.update {
                it.copy(confirm = event.value, error = null)
            }
        }
    }

    private fun submit() {
        val s = _state.value

        if (s.canSubmit) {
            val message = when  {
                !s.isNameValid -> RSD.INVALID_NAME_TEXT
                !s.isEmailValid -> RSD.INVALID_EMAIL_TEXT
                !s.isPasswordValid -> RSD.INVALID_PASSWORD_TEXT
                !s.isPasswordsMatch -> RSD.PASSWORD_MISMATCH_TEXT
                else -> RSD.UNKNOWN_DATA_TEXT
            }
            _state.update { it.copy(error = message) }
            return
        }

        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            val res = repository.signUp(
                fullName = s.fullName.trim(),
                email = s.email.trim(),
                password = s.password
            ).doOnSuccess {
                _state.update { it.copy(isLoading = false, isSuccess = true) }
            }.doOnError { err ->
                _state.update {
                    it.copy(isLoading = false, error = err.message ?: RSD.SIGN_UP_ERROR_TEXT)
                }
            }

        }
    }
}