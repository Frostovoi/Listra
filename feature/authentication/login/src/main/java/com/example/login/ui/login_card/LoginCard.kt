package com.example.login.ui.login_card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.api.states.LoginUiState
import com.example.login.LoginEvent
import com.example.login.utils.LoginScreenDefaults as LSD

@Composable
fun LoginCard(
    state: LoginUiState,
    onEvent: (LoginEvent) -> Unit,
) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = LSD.LoginCardElevation),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(
                alpha = LSD.LOGIN_CARD_COLOR_ALPHA
            )
        ),
        shape = RoundedCornerShape(LSD.CardShapeSmoothing)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(LSD.LoginCardColumnPad)
        ) {
            EmailField(
                state = state,
                onEvent = onEvent
            )

            Spacer(Modifier.height(LSD.EmailPasswordSpacer))

            PasswordField(
                state = state,
                onEvent = onEvent,
            )

            Spacer(Modifier.height(LSD.PasswordRowSpacer))

            RememberMeForgotPwdRow(
                state = state,
                onEvent = onEvent,
            )

            Spacer(Modifier.height(LSD.RememberSubmitSpacer))

            SubmitButton(
                state = state,
                onEvent = onEvent,
            )

            OrDivider()

            SocialButton(
                onGoogle = {
                    onEvent(LoginEvent.GoogleClick)
                }
            )

            Spacer(Modifier.height(LSD.SocialSignUpSpacer))

            SignUpRow(onEvent)


        }
    }
}






@Preview
@Composable
private fun LoginCardPreview() {
    MaterialTheme {
        LoginCard(state = LoginUiState(), {})
    }
}