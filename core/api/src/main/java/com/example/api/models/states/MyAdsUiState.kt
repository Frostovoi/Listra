package com.example.api.models.states

import com.example.api.models.ListingItem
import com.example.api.models.ListingTab

data class MyAdsUiState(
    val currentTab: ListingTab = ListingTab.Active,
    val isLoading: Boolean = false,
    val ads: List<ListingItem> = emptyList()
)