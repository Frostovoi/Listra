package com.example.login.ui.login_card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.login.utils.LoginScreenDefaults as LSD

@Composable
fun SocialButton(
    onGoogle: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedButton(
            onClick = onGoogle,
            modifier = Modifier
                .fillMaxWidth()
                .height(LSD.SocialButtonHeight)
        ) {
            Text(LSD.GOOGLE_BUTTON_TEXT)
        }
    }
}