package com.example.search_repo

import com.example.api.models.ListingItem
import com.example.api.repository.SearchRepository
import com.example.network.utils.Result
import com.example.search_repo.api.SearchApi
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val searchApi: SearchApi): SearchRepository {
    override suspend fun searchAds(query: String): Result<List<ListingItem>, Throwable> {
        TODO("Not yet implemented")
    }
}