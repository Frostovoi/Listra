package com.example.login.ui.login_card

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.login.utils.LoginScreenDefaults as LSD

@Composable
fun OrDivider(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = LSD.DividerVPad),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(Modifier.weight(LSD.DIVIDER_WEIGHT))
        Text(
            text = LSD.OR_DIVIDER_TEXT,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.labelMedium
        )
        HorizontalDivider(Modifier.weight(LSD.DIVIDER_WEIGHT))
    }
}