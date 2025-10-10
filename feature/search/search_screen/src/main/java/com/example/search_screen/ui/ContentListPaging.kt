package com.example.search_screen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.example.api.models.ListingItem
import com.example.api.models.states.SearchUiState
import com.example.search_screen.utils.SearchScreenDefaults
import kotlinx.coroutines.flow.Flow
import com.example.search_screen.R as SearchR
import com.example.search_screen.utils.SearchScreenDefaults as SSD


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentListPaging(
    pagingFlow: Flow<PagingData<ListingItem>>,
    state: SearchUiState,
    onOpenAd: (ListingItem) -> Unit,
    onQuickQuery: (String) -> Unit,
) {
    val ads = pagingFlow.collectAsLazyPagingItems()
    val gridState = rememberLazyGridState()
    val hasAds = ads.itemCount > 0

    val showRecs = state
        .searchQuery.isBlank()
            && !hasAds
            && ads.loadState.refresh is LoadState.Loading

    val initialLoading = (ads.loadState.refresh is LoadState.Loading) && !hasAds

    LazyVerticalGrid(
        state = gridState,
        columns = GridCells.Fixed(SSD.GRID_COLUMNS),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(SSD.GridPadding),
        verticalArrangement = Arrangement.spacedBy(SSD.GridPadding),
        horizontalArrangement = Arrangement.spacedBy(SSD.GridPadding)
    ) {
        if (showRecs) {
            item(key = "assist_chips", contentType = "chips", span = {
                GridItemSpan(maxLineSpan)
            }) {
                Column {
                    AssistChipRow(
                        onQuery = onQuickQuery,
                        suggestions = state.recommendations.map { it.title }
                    )
                    EmptyHint(text = stringResource(id = SearchR.string.search_empty_hint_before))

                }
            }
        }

        // Result header
        if (hasAds) {
            item(
                key = SSD.KEY_RESULTS,
                contentType = SSD.CT_HEADER,
                span = { GridItemSpan(maxLineSpan) }
            ) { SectionHeader(title = stringResource(
                id = SearchR.string.search_results_header
            ))
            }
        }

        items(
            count = ads.itemCount,
            key = ads.itemKey { it.id },
            contentType = ads.itemContentType()
        ) { index ->
            ads[index]?.let{ ad ->
                ListingRow(ad) { onOpenAd(ad) }
            }
        }

        // Initial loading
        if (initialLoading && !showRecs) {
            items(
                count = SSD.SKELETON_COUNT,
                contentType = { SSD.CT_SKELETON }) { LoadingRow() }
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

        // Recs
        if (state.recommendations.isNotEmpty()) {
            val recommendationsTitle =
                if (!hasAds)
                    SearchR.string.search_recommended_for_you
                else
                    SearchR.string.search_similar_ads

            // Recs header
            item(
                key = SSD.KEY_RECOMMENDATIONS,
                contentType = SSD.CT_HEADER,
                span = { GridItemSpan(maxLineSpan) }
            ){
                SectionHeader(stringResource(recommendationsTitle))
            }

            // Recs items
            items(
                items = state.recommendations,
                key = { it.id },
                contentType = { SSD.CT_LISTING }
            ){
                ListingRow(it) {
                    onOpenAd
                }
            }
        }
    }
}



@Composable
private fun EmptyHint(text: String) {
    Text(text, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(
        SearchScreenDefaults.HintPadAll
    ))
}