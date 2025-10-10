package com.example.login.previews

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.login.ui.Greeting

@Preview
@Composable
private fun GreetingPreview() {
    MaterialTheme {
        Column {
            Greeting(
                title = "Welcome Back",
                subtitle = "Sign in to continue"
            )
        }
    }
}