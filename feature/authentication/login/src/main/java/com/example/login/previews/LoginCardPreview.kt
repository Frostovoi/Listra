package com.example.login.previews

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.api.states.LoginUiState
import com.example.login.ui.login_card.LoginCard

@Preview
@Composable
private fun LoginCardPreview() {
    MaterialTheme {
        LoginCard(state = LoginUiState(), {})
    }
}