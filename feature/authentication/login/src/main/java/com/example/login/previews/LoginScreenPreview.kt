package com.example.login.previews

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.api.models.states.LoginUiState
import com.example.login.ui.LoginScreen

@Preview
@Composable
fun LoginScreenPreview() {
    MaterialTheme {
        val snackbar = remember { SnackbarHostState() }
        MaterialTheme {
            LoginScreen(
                state = LoginUiState(),
                onEvent = {},
                snackbarHostState = snackbar
            )
        }
    }
}