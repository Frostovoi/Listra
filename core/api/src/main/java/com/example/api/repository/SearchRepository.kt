package com.example.api.repository

import com.example.api.models.ListingItem
import com.example.api.models.Page
import com.example.network.utils.Result

interface SearchRepository {

    suspend fun searchAds(
        query: String,
        page: Int = 1,
        pageSize: Int = 20
    ): Result<Page<ListingItem>, Throwable>

}