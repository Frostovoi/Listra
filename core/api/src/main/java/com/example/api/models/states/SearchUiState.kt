package com.example.api.models.states

import com.example.api.models.ListingItem

data class SearchUiState(
    val isLoading: Boolean = false,
    val searchQuery: String = "",
    val ads: List<ListingItem> = emptyList()
)
