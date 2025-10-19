package com.example.register

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.example.register.ui.RegisterScreen
import com.example.register.utils.RegisterEffect

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterHost(
    vmFactory: ViewModelProvider.Factory,
    backStackEntry: NavBackStackEntry,
    onOpenSignIn: () -> Unit
) {

    val vm: RegisterViewModel = viewModel(viewModelStoreOwner = backStackEntry, factory = vmFactory)
    val ui by vm.state.collectAsStateWithLifecycle()
    val snackbar = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        vm.effects.collect { effect ->
            when(effect) {
                is RegisterEffect.OpenSignIn -> onOpenSignIn()
                is RegisterEffect.ShowMessage -> snackbar.showSnackbar(effect.text)
            }
        }
    }

    RegisterScreen(
        state = ui,
        onEvent = vm::onEvent,
        snackbarHostState = snackbar
    )

}