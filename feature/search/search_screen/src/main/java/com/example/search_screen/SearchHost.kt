package com.example.search_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.example.api.models.ListingItem
import com.example.api.models.states.SearchUiState
import com.example.search_screen.ui.SearchScreen

@RequiresApi(Build.VERSION_CODES.O)
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
        state = SearchUiState(
            searchQuery = "bike",
            resultAds = MockData.mockListingItems,
            isEmptyHintVisible = false,
            recommendations = MockData.mockListingRecs,
            history = listOf("bike", "car")
        ),
        onSearchQueryChange = {},
        onSearch = {},
        onBack = {},
        onOpenAd = {}
    )

//    SearchScreen(
//        state = state,
//        onSearchQueryChange = vm::onSearchQueryChange,
//        onOpenAd = onOpenAd,
//        onSearch = {},
//        onBack = {}
//    )
}