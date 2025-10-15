package com.example.search_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.example.api.models.ListingItem
import com.example.search_screen.ui.SearchScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SearchHost(
    vmFactory: ViewModelProvider.Factory,
    backStackEntry: NavBackStackEntry,
    onOpenAd: (ListingItem) -> Unit,
    onBack: () -> Unit
) {
    val vm: SearchViewModel = viewModel(
        viewModelStoreOwner = backStackEntry,
        factory = vmFactory
    )

    val ui by vm.uiState.collectAsStateWithLifecycle()
    val history by vm.history.collectAsStateWithLifecycle()


    SearchScreen(
        state = ui.copy(history = history),
        onSearchQueryChange = vm::onSearchQueryChange,
        onSearch = vm::onSearchSubmit,
        onBack = onBack,
        onOpenAd = onOpenAd,
        pagingFlow = vm.pagingFlow,
        onClearHistory = vm::onClearHistory
    )
}