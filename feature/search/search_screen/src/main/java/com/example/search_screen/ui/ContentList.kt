package com.example.search_screen.ui

import androidx.compose.runtime.Composable
import com.example.api.models.ListingItem
import com.example.api.models.states.SearchUiState

@Composable
fun ContentList(
    state: SearchUiState,
    onOpenAd: (ListingItem) -> Unit = {},
    onRetry: () -> Unit = {}
) {
    TODO()
}