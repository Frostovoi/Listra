package com.example.search_screen

import androidx.compose.runtime.Composable
import com.example.api.models.ListingItem
import com.example.api.models.states.SearchUiState

@Composable
fun SearchScreen(
    state: SearchUiState,
    onSearchQueryChange: (String) -> Unit,
    onOpenAd: (ListingItem) -> Unit
) {

}