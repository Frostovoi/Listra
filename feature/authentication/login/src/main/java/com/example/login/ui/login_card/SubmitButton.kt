package com.example.login.ui.login_card

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.api.models.states.LoginUiState
import com.example.login.LoginEvent
import com.example.login.utils.LoginScreenDefaults as LSD

@Composable
fun SubmitButton(
    onEvent: (LoginEvent) -> Unit,
    state: LoginUiState
) {
    Button(
        onClick = {
            onEvent(LoginEvent.Submit)
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(LSD.SubmitButtonHeight),
        enabled = !state.isLoading && state.email.isNotBlank() && state.password.isNotBlank()
    ) {
        Crossfade(
            targetState = state.isLoading,

            ) { loading ->
            if (loading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(LSD.ProgressIndicatorSize),
                    strokeWidth = LSD.ProgressIndicatorWidth
                )
            } else {
                Text(LSD.SIGN_IN_TEXT)
            }
        }
    }
    AnimatedVisibility(visible = state.formError != null) {
        Text(
            text = state.formError ?: "",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = LSD.SubmitErrorPad)
        )
    }
}