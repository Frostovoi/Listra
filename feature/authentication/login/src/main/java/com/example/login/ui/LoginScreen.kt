package com.example.login.ui

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
import com.example.api.states.LoginUiState
import com.example.login.utils.LoginEvent
import com.example.login.ui.login_card.LoginCard
import com.example.ui.auth.gradientBackground
import com.example.ui.auth.TitleColumn
import com.example.ui.utils.UiDefaults
import com.example.login.utils.LoginScreenDefaults as LSD

@Composable
fun LoginScreen(
    state: LoginUiState,
    onEvent: (LoginEvent) -> Unit,
    snackbarHostState: SnackbarHostState,
    title: String = LSD.TITLE_TEXT,
    subtitle: String = LSD.SUBTITLE_TEXT
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
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = UiDefaults.ColumnHPad)
                    .navigationBarsPadding()
                    .imePadding(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TitleColumn(
                    title = title,
                    subtitle = subtitle
                )
                LoginCard(
                    state = state,
                    onEvent = onEvent
                )

                if (state.isLoading) {
                    LoadingIndicator()
                }
            }
        }

    }
}




@Preview
@Composable
fun LoginScreenPreview() {
    MaterialTheme {
        val snackbar = remember { SnackbarHostState() }
        MaterialTheme {
            LoginScreen(
                state = LoginUiState(),
                onEvent = {},
                snackbarHostState = snackbar
            )
        }
    }
}