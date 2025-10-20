package com.example.ui.auth

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import com.example.ui.utils.UiDefaults.GRADIENT_COLOR_ALPHA_1
import com.example.ui.utils.UiDefaults.GRADIENT_COLOR_ALPHA_2
import com.example.ui.utils.UiDefaults.GRADIENT_COLOR_ALPHA_3

@Composable
fun gradientBackground(): Brush {
    val cs = MaterialTheme.colorScheme
    return Brush.verticalGradient(
        colors = listOf(
            cs.primary.copy(alpha = GRADIENT_COLOR_ALPHA_1),
            cs.primary.copy(alpha = GRADIENT_COLOR_ALPHA_2),
            cs.secondary.copy(alpha = GRADIENT_COLOR_ALPHA_3),
            cs.background
        )
    )
}