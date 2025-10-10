package com.example.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry


@Composable
fun LoginHost(
    vmFactory: ViewModelProvider.Factory,
    backStackEntry: NavBackStackEntry
) {
    val vm: LoginViewModel = viewModel(
        viewModelStoreOwner = backStackEntry
    )

    val ui by vm.uiState.collectAsStateWithLifecycle()

//    LoginScreen(
//        state = ui,
//
//    )
}