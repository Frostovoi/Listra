package com.example.search_screen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import com.example.search_screen.R as SearchR
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import com.example.api.models.ListingItem
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.example.search_screen.utils.SearchScreenDefaults as SSD
import kotlinx.coroutines.flow.Flow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentListPaging(
    pagingFlow: Flow<PagingData<ListingItem>>,
    onOpenAd: (ListingItem) -> Unit
) {
    val ads = pagingFlow.collectAsLazyPagingItems()
    val gridState = rememberLazyGridState()


    LazyVerticalGrid(
        state = gridState,
        columns = GridCells.Fixed(SSD.GRID_COLUMNS),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(SSD.GridPadding),
        verticalArrangement = Arrangement.spacedBy(SSD.GridPadding),
        horizontalArrangement = Arrangement.spacedBy(SSD.GridPadding)
    ) {
        items(
            count = ads.itemCount,
            key = ads.itemKey { it.id },
            contentType = ads.itemContentType()
            ) { index ->
            val ad = ads[index]
            if (ad != null) ListingRow(ad) { onOpenAd }
        }


        // First loading
        when (val refreshState = ads.loadState.refresh) {
            is LoadState.Loading -> items(6) { LoadingRow() }
            is LoadState.Error -> item { ErrorRow(
                message = refreshState.error.message ?: stringResource(id =
                    SearchR.string.search_error_unknown)) { ads.retry() }
            }
            else -> Unit
        }

        // Tail loading
        when (val appendState = ads.loadState.append) {
            is LoadState.Loading -> item{ LoadingRow() }
            is LoadState.Error -> item {
                ErrorRow(
                    message = appendState.error.message ?: stringResource(
                        id =
                            SearchR.string.search_error_unknown
                    )
                ) { ads.retry() }
            }
            else -> Unit
        }
    }
}