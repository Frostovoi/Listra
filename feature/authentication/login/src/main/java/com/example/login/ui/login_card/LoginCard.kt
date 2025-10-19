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
import com.example.login.utils.LoginEvent
import com.example.ui.auth.BottomRow
import com.example.ui.auth.EmailField
import com.example.ui.auth.PasswordField
import com.example.ui.auth.SocialButton
import com.example.ui.auth.SubmitButton
import com.example.ui.utils.UiDefaults.CARD_COLOR_ALPHA
import com.example.ui.utils.UiDefaults.CardColumnPad
import com.example.ui.utils.UiDefaults.CardElevation
import com.example.ui.utils.UiDefaults.CardShapeSmoothing
import com.example.login.utils.LoginScreenDefaults as LSD

@Composable
fun LoginCard(
    state: LoginUiState,
    onEvent: (LoginEvent) -> Unit,
) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = CardElevation),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(
                alpha = CARD_COLOR_ALPHA
            )
        ),
        shape = RoundedCornerShape(CardShapeSmoothing)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CardColumnPad)
        ) {
            EmailField(
                emailLabel = LSD.EMAIL_LABEL,
                emailValue = state.email,
                emailError = state.emailError,
                onEmailChanged = { onEvent(LoginEvent.EmailChanged(value = it))}
            )

            Spacer(Modifier.height(LSD.EmailPasswordSpacer))

            PasswordField(
                passwordValue = state.password,
                passwordLabel = LSD.PASSWORD_LABEL,
                passwordError = state.passwordError,
                onPasswordChanged = { onEvent(LoginEvent.PasswordChanged(it)) },
                onSubmit = { onEvent(LoginEvent.Submit)}
            )

            Spacer(Modifier.height(LSD.PasswordRowSpacer))

            RememberMeForgotPwdRow(
                state = state,
                onEvent = onEvent,
            )

            Spacer(Modifier.height(LSD.RememberSubmitSpacer))

            SubmitButton(
                onSubmit = { onEvent(LoginEvent.Submit) },
                enabled = !state.isLoading && state.email.isNotBlank() && state.password.isNotBlank(),
                isLoading = state.isLoading,
                label = LSD.SIGN_IN_TEXT,
                formError = state.formError
            )

            OrDivider()

            SocialButton(
                label = LSD.GOOGLE_BUTTON_TEXT,
                onButtonPressed = {
                    onEvent(LoginEvent.GoogleClick)
                }
            )

            Spacer(Modifier.height(LSD.SocialSignUpSpacer))

            BottomRow(
                initialText = LSD.NO_ACCOUNT_TEXT,
                navigationText = LSD.SIGN_UP_TEXT,
                onNavigation = { onEvent(LoginEvent.SignUpClick) }
            )
        }
    }
}






