package com.example.login.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.login.utils.LoginScreenDefaults as LSD

@Composable
fun Greeting(
    title: String,
    subtitle: String
) {

    Text(
        text = title,
        style = MaterialTheme.typography.headlineMedium.copy(
            fontWeight = FontWeight.Bold,
            letterSpacing = LSD.TitleLetterSpacing
        ),
        color = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = LSD.TitleBottomPad),
        textAlign = TextAlign.Start
    )

    Text(
        text = subtitle,
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = LSD.   SUBTITLE_COLOR_ALPHA),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = LSD.SubtitleBottomPad)
    )

}