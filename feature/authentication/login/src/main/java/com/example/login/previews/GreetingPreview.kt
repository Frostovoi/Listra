package com.example.login.previews

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui.auth.TitleColumn

@Preview
@Composable
private fun GreetingPreview() {
    MaterialTheme {
        Column {
            TitleColumn(
                title = "Welcome Back",
                subtitle = "Sign in to continue"
            )
        }
    }
}