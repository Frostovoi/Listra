package com.example.ui.auth

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
import com.example.api.states.LoginUiState
import com.example.ui.utils.UiDefaults.ProgressIndicatorSize
import com.example.ui.utils.UiDefaults.ProgressIndicatorWidth
import com.example.ui.utils.UiDefaults.SubmitButtonHeight
import com.example.ui.utils.UiDefaults.SubmitErrorPad

@Composable
fun SubmitButton(
    onSubmit: () -> Unit,
    enabled: Boolean,
    isLoading: Boolean,
    label: String,
    formError: String? = null
) {
    Button(
        onClick = {
            onSubmit()
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(SubmitButtonHeight),
        enabled = enabled
    ) {
        Crossfade(
            targetState = isLoading,

            ) { loading ->
            if (loading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(ProgressIndicatorSize),
                    strokeWidth = ProgressIndicatorWidth
                )
            } else {
                Text(label)
            }
        }
    }
    AnimatedVisibility(visible = formError != null) {
        Text(
            text = formError ?: "",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = SubmitErrorPad)
        )
    }
}