package com.example.reset.ui

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
import com.example.api.states.ResetUiState
import com.example.reset.utils.ResetEvent
import com.example.reset.utils.ResetScreenDefaults
import com.example.ui.auth.BottomRow
import com.example.ui.auth.EmailField
import com.example.ui.auth.SubmitButton
import com.example.ui.utils.UiDefaults.CARD_COLOR_ALPHA
import com.example.ui.utils.UiDefaults.CardColumnPad
import com.example.ui.utils.UiDefaults.CardElevation
import com.example.ui.utils.UiDefaults.CardShapeSmoothing

@Composable
fun ResetCard(
    state: ResetUiState,
    onEvent: (ResetEvent) -> Unit,
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
                emailValue = state.email,
                emailError = state.emailError,
                emailLabel = ResetScreenDefaults.EMAIL_LABEL,
                onEmailChanged = { onEvent(ResetEvent.EmailChanged(value = it)) }
            )

            Spacer(Modifier.height(ResetScreenDefaults.EmailSubmitSpacer))

            SubmitButton(
                onSubmit = { onEvent(ResetEvent.Submit) },
                enabled = !state.isSubmitting && state.email.isNotBlank(),
                isLoading = state.isSubmitting,
                label = ResetScreenDefaults.RESET_BUTTON_TEXT,
                formError = state.emailError
            )

            Spacer(Modifier.height(ResetScreenDefaults.SubmitBottomSpacer))

            BottomRow(
                initialText = ResetScreenDefaults.BOTTOM_INITIAL_TEXT,
                navigationText = ResetScreenDefaults.BOTTOM_NAVIGATION_TEXT,
                onNavigation = { onEvent(ResetEvent.SignInClick) }
            )
        }
    }
}