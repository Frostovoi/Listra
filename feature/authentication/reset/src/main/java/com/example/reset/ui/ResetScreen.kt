package com.example.reset.ui

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
import com.example.api.states.ResetUiState
import com.example.reset.utils.ResetEvent
import com.example.reset.utils.ResetScreenDefaults
import com.example.ui.auth.BottomRow
import com.example.ui.auth.SubmitButton
import com.example.ui.auth.TitleColumn
import com.example.ui.auth.gradientBackground
import com.example.ui.utils.UiDefaults.ColumnHPad


@Composable
fun ResetScreen(
    state: ResetUiState,
    onEvent: (ResetEvent) -> Unit,
    snackbarHostState: SnackbarHostState,
    title: String = ResetScreenDefaults.TITLE_TEXT,
    subtitle: String = ResetScreenDefaults.SUBTITLE_TEXT
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

                ResetCard(
                    state = state,
                    onEvent = onEvent
                )

            }


        }
    }
}


@Preview
@Composable
fun ResetScreenPreview() {
    MaterialTheme {
        val snackbar = remember { SnackbarHostState() }
        ResetScreen(
            state = ResetUiState(),
            onEvent = {},
            snackbarHostState = snackbar
        )
    }
}
