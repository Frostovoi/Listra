package com.example.register.ui

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
import com.example.api.states.RegisterUiState
import com.example.register.utils.RegisterEvent
import com.example.register.utils.RegisterScreenDefaults
import com.example.ui.auth.BottomRow
import com.example.ui.auth.EmailField
import com.example.ui.auth.FullNameField
import com.example.ui.auth.PasswordField
import com.example.ui.auth.SubmitButton
import com.example.ui.utils.UiDefaults.CARD_COLOR_ALPHA
import com.example.ui.utils.UiDefaults.CardColumnPad
import com.example.ui.utils.UiDefaults.CardElevation
import com.example.ui.utils.UiDefaults.CardShapeSmoothing

@Composable
fun RegisterCard(
    state: RegisterUiState,
    onEvent: (RegisterEvent) -> Unit,
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
            FullNameField(
                fullNameValue = state.fullName,
                fullNameError = state.fullNameError,
                label = RegisterScreenDefaults.FULL_NAME_LABEL,
                onFullNameChanged = { onEvent(RegisterEvent.NameChanged(it)) }
            )



            EmailField(
                emailValue = state.email,
                emailError = state.emailError,
                emailLabel = RegisterScreenDefaults.EMAIL_LABEL,
                onEmailChanged = { onEvent(RegisterEvent.EmailChanged(value = it)) }
            )

            PasswordField(
                passwordValue = state.password,
                passwordError = state.passwordError,
                passwordLabel = RegisterScreenDefaults.PASSWORD_LABEL,
                onPasswordChanged = { onEvent(RegisterEvent.PasswordChanged(value = it)) }
            )



            PasswordField(
                passwordValue = state.confirm,
                passwordError = state.confirmError,
                passwordLabel = RegisterScreenDefaults.PASSWORD_REPEAT_LABEL,
                onPasswordChanged = { onEvent(RegisterEvent.ConfirmChanged(value = it)) }
            )

            Spacer(Modifier.height(RegisterScreenDefaults.TextFieldButtonSpacer))

            SubmitButton(
                onSubmit = { onEvent(RegisterEvent.Submit) },
                enabled = !state.isLoading
                        && state.email.isNotBlank()
                        && state.password.isNotBlank()
                        && state.confirm.isNotBlank(),
                isLoading = state.isLoading,
                label = RegisterScreenDefaults.SIGN_UP_TEXT,
                formError = state.formError
            )

            Spacer(Modifier.height(RegisterScreenDefaults.ButtonBottomRowSpacer))

            BottomRow(
                initialText = RegisterScreenDefaults.HAVE_ACCOUNT_TEXT,
                navigationText = RegisterScreenDefaults.SIGN_IN_TEXT,
                onNavigation = { onEvent(RegisterEvent.SignInClick)}
            )

        }
    }
}