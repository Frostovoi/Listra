package com.example.search_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.example.api.models.ListingItem

@Composable
fun SearchHost(
    vmFactory: ViewModelProvider.Factory,
    backStackEntry: NavBackStackEntry,
    onOpenAd: (ListingItem) -> Unit
) {
    val vm: SearchViewModel = viewModel(
        viewModelStoreOwner = backStackEntry,
        factory = vmFactory
    )
    val state = vm.uiState.collectAsState().value

    SearchScreen(
        state = state,
        onSearchQueryChange = vm::onSearchQueryChange,
        onOpenAd = onOpenAd
    )
}