package com.example.my_ads

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.example.api.models.ListingItem

@Composable
fun MyAdsHost(
    vmFactory: ViewModelProvider.Factory,
    backStackEntry: NavBackStackEntry,
    onOpenAd: (ListingItem) -> Unit,
    onAddNewAdClick: () -> Unit
) {
    val vm: MyAdsViewModel = viewModel(
        viewModelStoreOwner = backStackEntry,
        factory = vmFactory
    )
    val state = vm.uiState

    MyAdsScreen(
        state = state,
        onAddNewAdClick = onAddNewAdClick,
        onOpenAd = onOpenAd,
        onTabChange = vm::onTabChange
    )
}