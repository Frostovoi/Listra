package com.example.login.ui.login_card

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import com.example.api.models.states.LoginUiState
import com.example.login.LoginEvent
import com.example.login.utils.LoginScreenDefaults as LSD

@Composable
fun EmailField(
    state: LoginUiState,
    onEvent: (LoginEvent) -> Unit
) {
    OutlinedTextField(
        value = state.email,
        onValueChange = { onEvent(LoginEvent.EmailChanged(value = it)) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(LSD.EMAIL_LABEL)},
        placeholder = { Text(LSD.EMAIL_PLACEHOLDER)},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null
            )
        },
        singleLine = true,
        isError = state.emailError != null,
        supportingText = {
            AnimatedVisibility(visible = state.emailError != null ) {
                Text(
                    text = state.emailError ?: "",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        )
    )
}