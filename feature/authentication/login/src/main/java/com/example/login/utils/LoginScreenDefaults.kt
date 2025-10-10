package com.example.login.utils

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Stable
internal object LoginScreenDefaults {

    const val GRADIENT_COLOR_ALPHA_1 = 0.85f
    const val GRADIENT_COLOR_ALPHA_2 = 0.65f
    const val GRADIENT_COLOR_ALPHA_3 = 0.55f
    const val SUBTITLE_COLOR_ALPHA = 0.85f
    const val LOGIN_CARD_COLOR_ALPHA = 0.96f
    const val REMEMBER_ME_COLOR_ALPHA = 0.3f
    const val LOADING_STATE_COLOR_ALPHA = 0.35f

    const val EMAIL_LABEL = "Email"
    const val PASSWORD_LABEL = "Password"

    const val EMAIL_PLACEHOLDER = "you@mail.com"
    const val PASSWORD_PLACEHOLDER = "••••••••"

    const val REMEMBER_ME_TEXT = "Remember me"
    const val FORGOT_PASSWORD_TEXT = "Forgot password?"
    const val SIGN_IN_TEXT = "Sign in"
    const val OR_DIVIDER_TEXT = "  or  "
    const val GOOGLE_BUTTON_TEXT = "Continue with Google"
    const val NO_ACCOUNT_TEXT = "No account yet? "
    const val SIGN_UP_TEXT = "Sign up"
    const val LOADING_TEXT = "Signing in…"

    const val DIVIDER_WEIGHT = 1f

    val TitleLetterSpacing = 0.5.sp
    val LoginCardElevation = 10.dp
    val CardShapeSmoothing = 24.dp

    val ColumnHPad = 24.dp
    val TitleBottomPad = 4.dp
    val SubtitleBottomPad = 24.dp
    val LoginCardColumnPad = 20.dp
    val EmailPasswordSpacer = 12.dp
    val PasswordRowSpacer = 8.dp

    val RememberMeBoxSize = 20.dp
    val RememberMeBoxCorner = 6.dp
    val RememberMeBoxBorderWidth = 1.5.dp
    val RememberMeBoxTextSpacer = 8.dp

    val RememberSubmitSpacer = 12.dp
    val SubmitButtonHeight = 52.dp
    val ProgressIndicatorSize = 22.dp
    val ProgressIndicatorWidth = 2.dp
    val SubmitErrorPad = 8.dp

    val DividerVPad = 16.dp

    val SocialButtonHeight = 50.dp

    val SocialSignUpSpacer = 8.dp

    val LoadingStateElevation = 8.dp
    val LoadingCornerSmoothing = 16.dp
    val LoadingRowVPad = 12.dp
    val LoadingRowHPad = 16.dp
    val LoadingIndicatorSize = 22.dp
    val LoadingIndicatorWidth = 2.dp
    val IndicatorTextSpacer = 12.dp

}