package com.example.ui.auth

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
import com.example.ui.utils.UiDefaults.EMAIL_LABEL
import com.example.ui.utils.UiDefaults.EMAIL_PLACEHOLDER


@Composable
fun EmailField(
    emailValue: String,
    emailError: String?,
    emailLabel: String,
    onEmailChanged: (String) -> Unit
) {
    OutlinedTextField(
        value = emailValue,
        onValueChange = onEmailChanged,
        modifier = Modifier.fillMaxWidth(),
        label = { Text(emailLabel)},
        placeholder = { Text(EMAIL_PLACEHOLDER)},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null
            )
        },
        singleLine = true,
        isError = emailError != null,
        supportingText = {
            AnimatedVisibility(visible = emailError != null ) {
                Text(
                    text = emailError ?: "",
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