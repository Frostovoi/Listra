package com.example.api.repository

import com.example.api.models.ListingItem
import com.example.api.models.ListingTab

interface  AdsRepository {

    suspend fun loadAds(tab: ListingTab): List<ListingItem>
}