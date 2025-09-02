package com.example.auth

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AuthScreen() {
    Scaffold { paddingValues ->
        Text(
            text = "Auth Screen",
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .wrapContentSize()
        )

    }
}