package com.example.ui.utils

import android.util.Patterns
import com.example.ui.utils.UiDefaults.BLANK_EMAIL_TEXT
import com.example.ui.utils.UiDefaults.INVALID_EMAIL_TEXT
import com.example.ui.utils.UiDefaults.SHORT_PASSWORD_TEXT

fun validateEmail(email: String): String? =
    if (email.isBlank()) {
        BLANK_EMAIL_TEXT
    } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
        INVALID_EMAIL_TEXT
    } else null

fun validatePassword(pwd: String): String? =
    if (pwd.length < 8) SHORT_PASSWORD_TEXT else null