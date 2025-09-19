package com.example.api.repository

import com.example.api.models.ListingItem
import com.example.network.utils.Result

interface SearchRepository {

    suspend fun searchAds(query: String): Result<List<ListingItem>, Throwable>
}