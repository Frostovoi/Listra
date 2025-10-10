package com.example.login.ui.login_card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.login.LoginEvent
import com.example.login.utils.LoginScreenDefaults as LSD

@Composable
fun SignUpRow(
    onEvent: (LoginEvent) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = LSD.NO_ACCOUNT_TEXT,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = LSD.SIGN_UP_TEXT,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable { onEvent(LoginEvent.SignUpClick) }
        )
    }
}