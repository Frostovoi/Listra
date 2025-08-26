package com.example.my_ads.models

data class MyAdsUiState(
    val currentTab: ListingTab = ListingTab.Active,
    val isLoading: Boolean = false,
    val listingItems: List<ListingItem> = emptyList()
)