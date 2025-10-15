package com.example.login

import android.util.Log
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.example.api.utils.doOnError
import com.example.api.utils.doOnSuccess
import com.example.identity_api.GoogleIdentityProvider
import com.example.login.ui.LoginScreen
import com.example.login.utils.LoginScreenDefaults


@Composable
fun LoginHost(
    vmFactory: ViewModelProvider.Factory,
    backStackEntry: NavBackStackEntry,
    googleIdentity: GoogleIdentityProvider,
    onOpenForgot: () -> Unit,
    onOpenSignUp: () -> Unit,
) {
    val snackbar = remember { SnackbarHostState() }
    val vm: LoginViewModel = viewModel(viewModelStoreOwner = backStackEntry, factory = vmFactory)
    val ui by vm.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        vm.effects.collect{ eff ->
            when (eff) {
                is LoginEffect.StartGoogleSignIn -> {
                    googleIdentity.requestIdToken(context)
                        .doOnSuccess {
                            vm.onGoogleIdToken(idToken = it)
                            Log.d("LoginHost", it)
                        }
                        .doOnError {
                            snackbar.showSnackbar(
                                message = it.message ?: LoginScreenDefaults.GOOGLE_ERROR_TEXT
                            )
                        }
                }
                is LoginEffect.ShowMessage -> snackbar.showSnackbar(eff.text)
            }
        }
    }

    LoginScreen(
        state = ui,
        onEvent = {
            when (it) {
                is LoginEvent.ForgotPasswordClick -> onOpenForgot()
                is LoginEvent.SignUpClick -> onOpenSignUp()
                else -> vm.onEvent(it)
            }
        },
        snackbarHostState = snackbar,
    )
}