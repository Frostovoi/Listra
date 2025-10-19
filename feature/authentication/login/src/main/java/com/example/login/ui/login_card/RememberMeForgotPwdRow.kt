package com.example.login.ui.login_card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import com.example.api.states.LoginUiState
import com.example.login.utils.LoginEvent
import com.example.login.utils.LoginScreenDefaults as LSD


@Composable
fun RememberMeForgotPwdRow(
    onEvent: (LoginEvent) -> Unit,
    state: LoginUiState
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checked = state.rememberMe
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.toggleable(
                value = checked,
                role = Role.Checkbox
            ) { onEvent(LoginEvent.RememberMeChanged(!checked)) }
        ) {
            Box(
                modifier = Modifier
                    .size(LSD.RememberMeBoxSize)
                    .clip(RoundedCornerShape(LSD.RememberMeBoxCorner))
                    .border(
                        width = LSD.RememberMeBoxBorderWidth,
                        color = MaterialTheme.colorScheme.outline,
                        shape = RoundedCornerShape(LSD.RememberMeBoxCorner))
                    .background(
                        color = if (checked) {
                            MaterialTheme.colorScheme.primary.copy(
                                LSD.REMEMBER_ME_COLOR_ALPHA
                            )
                        } else Color.Transparent
                    )
            ) {
                if (checked) {
                    Icon(
                        imageVector = Icons.Rounded.Check,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                    )
                }
            }

            Spacer(Modifier.size(LSD.RememberMeBoxTextSpacer))

            // RememberMe Text
            Text(
                text = LSD.REMEMBER_ME_TEXT,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        // Forgot text
        TextButton(onClick = { onEvent(LoginEvent.ForgotPasswordClick) }) {
            Text(LSD.FORGOT_PASSWORD_TEXT)
        }
    }
}