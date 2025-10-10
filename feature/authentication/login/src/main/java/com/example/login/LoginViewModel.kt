package com.example.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.models.states.AuthUiState
import com.example.api.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState>
        get() = _uiState.asStateFlow()


    fun onLoginSubmit() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true, error = null)
            }
        }
    }


}