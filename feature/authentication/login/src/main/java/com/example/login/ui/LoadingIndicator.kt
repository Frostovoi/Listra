package com.example.login.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.login.utils.LoginScreenDefaults as LSD

@Composable
fun LoadingIndicator() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background.copy(
                alpha = LSD.LOADING_STATE_COLOR_ALPHA)
            ),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            tonalElevation = LSD.LoadingStateElevation,
            shape = RoundedCornerShape(LSD.LoadingCornerSmoothing)
        ) {
            Row(
                modifier = Modifier.padding(
                    horizontal = LSD.LoadingRowHPad,
                    vertical = LSD.LoadingRowVPad
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(LSD.LoadingIndicatorSize),
                    strokeWidth = LSD.LoadingIndicatorWidth
                )
                Spacer(Modifier.size(LSD.IndicatorTextSpacer))
                Text(LSD.LOADING_TEXT)
            }
        }
    }
}