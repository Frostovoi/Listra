package com.example.ui.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.ui.utils.UiDefaults

@Composable
fun TitleColumn(
    title: String,
    subtitle: String
) {

    Text(
        text = title,
        style = MaterialTheme.typography.headlineMedium.copy(
            fontWeight = FontWeight.Bold,
            letterSpacing = UiDefaults.TitleLetterSpacing
        ),
        color = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = UiDefaults.TitleBottomPad),
        textAlign = TextAlign.Center
    )

    Text(
        text = subtitle,
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = UiDefaults.SUBTITLE_COLOR_ALPHA),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = UiDefaults.SubtitleBottomPad),
        textAlign = TextAlign.Center
    )
}