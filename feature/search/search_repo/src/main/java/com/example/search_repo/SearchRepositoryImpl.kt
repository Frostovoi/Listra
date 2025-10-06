package com.example.search_repo

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.api.models.ListingItem
import com.example.api.models.Page
import com.example.api.repository.SearchRepository
import com.example.network.utils.Result
import com.example.network.utils.runOperationCatching
import com.example.search_repo.api.SearchApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val searchApi: SearchApi): SearchRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun searchAds(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<Page<ListingItem>, Throwable> {
        return runOperationCatching {
            val dto = searchApi.searchAds(query, page, pageSize)

            Page(
                items = dto.toSearchResponseList(),
                total = dto.total,
                page = dto.page,
                pageSize = dto.pageSize
            )
        }
    }
}

