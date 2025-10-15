package com.example.api.repository

import com.example.api.models.ListingItem
import com.example.api.models.ListingTab
import com.example.api.utils.Result

interface  AdsRepository {

    suspend fun loadAds(tab: ListingTab): Result<List<ListingItem>, Throwable>
}