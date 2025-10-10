package com.example.login.ui.login_card

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.api.models.states.LoginUiState
import com.example.login.LoginEvent
import com.example.login.utils.LoginScreenDefaults as LSD

@Composable
fun PasswordField(
    state: LoginUiState,
    onEvent: (LoginEvent) -> Unit,
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = state.password,
        onValueChange = { onEvent(LoginEvent.PasswordChanged(it))},
        modifier = Modifier.fillMaxWidth(),
        label = { Text(LSD.PASSWORD_LABEL) },
        placeholder = { Text(LSD.PASSWORD_PLACEHOLDER) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null
            )
        },
        trailingIcon = {
            val (icon, desc) = if (passwordVisible) {
                Icons.Default.VisibilityOff to "Hide"
            } else {
                Icons.Default.Visibility to "Show"
            }
            IconButton(
                onClick = { passwordVisible = !passwordVisible }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = desc
                )
            }
        },
        singleLine = true,
        isError = state.passwordError != null,
        supportingText = {
            AnimatedVisibility(visible = state.passwordError != null) {
                Text(
                    text = state.passwordError ?: "",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        },
        visualTransformation = if (passwordVisible) {
            VisualTransformation.None
        } else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
                onEvent(LoginEvent.Submit)
            }
        )
    )
}