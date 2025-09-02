package com.example.api.models

data class MyAdsUiState(
    val currentTab: ListingTab = ListingTab.Active,
    val isLoading: Boolean = false,
    val ads: List<ListingItem> = emptyList()
)