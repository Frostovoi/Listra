package com.example.register.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.api.states.RegisterUiState
import com.example.register.utils.RegisterEvent
import com.example.ui.auth.gradientBackground
import com.example.ui.auth.TitleColumn
import com.example.ui.utils.UiDefaults
import com.example.ui.utils.UiDefaults.ColumnHPad
import com.example.register.utils.RegisterScreenDefaults as RSD

@Composable
fun RegisterScreen(
    state: RegisterUiState,
    onEvent: (RegisterEvent) -> Unit,
    snackbarHostState: SnackbarHostState,
    title: String = RSD.TITLE_TEXT,
    subtitle: String = RSD.SUBTITLE_TEXT

) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Transparent,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradientBackground())
                .padding(paddingValues)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = ColumnHPad)
                    .navigationBarsPadding()
                    .imePadding(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TitleColumn(
                    title = title,
                    subtitle = subtitle
                )

                RegisterCard(
                    state = state,
                    onEvent = onEvent
                )
            }
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    MaterialTheme {
        val snackbar = remember { SnackbarHostState() }
        RegisterScreen(
            state = RegisterUiState(),
            onEvent = {},
            snackbarHostState = snackbar
        )
    }
}