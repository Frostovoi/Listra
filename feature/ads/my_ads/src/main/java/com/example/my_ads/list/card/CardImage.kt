package com.example.my_ads.list.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardImage(url: String?) {
    val size = 84.dp
    val shape = RoundedCornerShape(8.dp)
    Box(
        modifier = Modifier
            .size(size)
            .clip(shape),
        contentAlignment = Alignment.Center
    ) {
        if (url.isNullOrBlank()) {
            Box(
                Modifier
                    .matchParentSize()
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            )
            Text(text = "No image", fontSize = 11.sp)
        }
    }
}


@Preview
@Composable
fun CardImagePreview() {
    MaterialTheme() {
        CardImage(null)
    }
}