package com.example.reset

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.states.RegisterUiState
import com.example.api.states.ResetUiState
import com.example.reset.utils.ResetEffect
import com.example.reset.utils.ResetEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class ResetViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(ResetUiState())
    val state: StateFlow<ResetUiState>
        get() = _state.asStateFlow()

    private val _effects = MutableSharedFlow<ResetEffect>()
    val effects: SharedFlow<ResetEffect>
        get() = _effects.asSharedFlow()

    fun onEvent(event: ResetEvent) {
        when(event) {
            ResetEvent.BackClick -> TODO()
            is ResetEvent.EmailChanged -> viewModelScope.launch {
                _state.update { it.copy(email = event.value, emailError = null)
                }
            }
            ResetEvent.SignInClick -> viewModelScope.launch {
                _effects.emit(ResetEffect.NavigateSignIn)
            }
            ResetEvent.Submit -> submit()
        }
    }

    private fun submit() {

    }
}