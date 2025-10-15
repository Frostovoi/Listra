package com.example.api.states

import com.example.api.models.ListingItem

data class SearchUiState(
    val isLoading: Boolean = false,
    val searchQuery: String = "",
    val resultAds: List<ListingItem> = emptyList(),
    val history: List<String> = emptyList(),
    val error: String? = null,
    val isEmptyHintVisible: Boolean = true,
    val recommendations: List<ListingItem> = emptyList()
)
