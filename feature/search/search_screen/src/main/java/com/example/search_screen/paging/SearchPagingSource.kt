package com.example.search_screen.paging

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.api.models.ListingItem
import com.example.api.repository.SearchRepository
import com.example.network.utils.getOrThrow
import com.example.network.utils.mapSuccess
import kotlinx.coroutines.flow.Flow

class SearchPagingSource(
    private val searchRepository: SearchRepository,
    private val query: String,
    private val pageSize: Int
): PagingSource<Int, ListingItem>(){

    override fun getRefreshKey(state: PagingState<Int, ListingItem>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.let {
                it.prevKey?.plus(1) ?: it.nextKey?.minus(1)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListingItem> = try {
        val page = params.key ?: 1

        searchRepository.searchAds(query, page, pageSize).mapSuccess { result ->
            val isLast = result.items.isEmpty() || (result.page * result.pageSize) >= result.total
            LoadResult.Page(
                data = result.items,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (isLast) null else page + 1
            )
        }.getOrThrow()
    } catch (t: Throwable) {
        LoadResult.Error(t)
    }
}

fun SearchRepository.asPager(
    query: String,
    pageSize: Int
): Flow<PagingData<ListingItem>> = Pager(
    config = PagingConfig(
        pageSize = pageSize,
        enablePlaceholders = false
    ),
    pagingSourceFactory = {
        SearchPagingSource(
            searchRepository = this,
            query = query,
            pageSize = pageSize
        )
    }
).flow