package com.example.reset

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.example.reset.ui.ResetScreen
import com.example.reset.utils.ResetEffect

@Composable
fun ResetHost(
    vmFactory: ViewModelProvider.Factory,
    backStackEntry: NavBackStackEntry,
    onOpenSignIn: () -> Unit
) {
    val snackbar = remember { SnackbarHostState() }
    val vm: ResetViewModel = viewModel(viewModelStoreOwner = backStackEntry, factory = vmFactory)
    val state by vm.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        vm.effects.collect { effect ->
            when(effect) {
                is ResetEffect.NavigateSignIn -> onOpenSignIn()
                is ResetEffect.ShowMessage -> snackbar.showSnackbar(effect.text)
                ResetEffect.NavigateBack -> TODO()
            }
        }
    }


    ResetScreen(
        state = state,
        onEvent = vm::onEvent,
        snackbarHostState = snackbar,
    )

}