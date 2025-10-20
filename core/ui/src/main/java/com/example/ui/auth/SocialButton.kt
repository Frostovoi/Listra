package com.example.ui.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ui.utils.UiDefaults.SocialButtonHeight

@Composable
fun SocialButton(
    onButtonPressed: () -> Unit,
    label: String
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedButton(
            onClick = onButtonPressed,
            modifier = Modifier
                .fillMaxWidth()
                .height(SocialButtonHeight)
        ) {
            Text(label)
        }
    }
}