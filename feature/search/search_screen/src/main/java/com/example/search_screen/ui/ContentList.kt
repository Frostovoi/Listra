package com.example.search_screen.ui

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.search_screen.R as SearchR

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.api.models.ListingItem
import com.example.api.models.states.SearchUiState
import com.example.search_screen.MockData
import com.example.search_screen.SearchScreenDefaults


@Composable
fun ContentList(
    state: SearchUiState,
    onOpenAd: (ListingItem) -> Unit = {},
    onRetry: () -> Unit = {},
    onQuickQuery: (String) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(SearchScreenDefaults.ContentBottomPadding),
    ) {
        val showRecs = state
            .searchQuery.isBlank()
                && state.resultAds.isEmpty()
                && !state.isLoading
                && state.error == null
        if (showRecs) {
            item(key = "assist_chips", contentType = "chips") {
                AssistChipRow(
                    onQuery = onQuickQuery,
                    suggestions = state.recommendations.map{it.title}
                )
                EmptyHint(text = stringResource(id = SearchR.string.search_empty_hint_before))
            }
        }

        when {
            state.isLoading -> {
                items(
                    count = SearchScreenDefaults.SKELETON_COUNT,
                    key = { "loading_$it" },
                    contentType = { "skeleton" }
                ) {
                    LoadingRow()
                }
            }

            state.error != null -> {
                item(key = "error", contentType = "error") {
                    ErrorRow(
                        message = state.error ?: stringResource(
                            id = SearchR.string.search_error_unknown
                        ),
                        onRetry = onRetry
                    )
                }
            }

            else -> {
                Log.d("ContentList", "state.resultAds.isNotEmpty(): ${state.resultAds.isNotEmpty()}")
                listingSection(
                    keyPrefix = "results",
                    ads = state.resultAds,
                    onOpenAd = onOpenAd,
                    header =
                        if (state.resultAds.isNotEmpty()) {
                            { SectionHeader(title = stringResource(
                                id = SearchR.string.search_results_header
                            ))}
                        } else null
                )

                if (state.recommendations.isNotEmpty()) {
                    val recommendationsTitle =
                        if (state.resultAds.isEmpty())
                            SearchR.string.search_recommended_for_you
                        else
                            SearchR.string.search_similar_ads
                    listingSection(
                        keyPrefix = "recommendations",
                        ads = state.recommendations,
                        onOpenAd = onOpenAd,
                        header = { SectionHeader(
                            title = stringResource(id = recommendationsTitle)
                        ) }
                    )
                }
                if (state.resultAds.isEmpty() && !showRecs) {
                    item(key = "empty", contentType = "empty") {
                        EmptyHint(text = stringResource(id = SearchR.string.search_empty_hint_after))
                    }
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



private fun LazyGridScope.listingSection(
    keyPrefix: String,
    ads: List<ListingItem>,
    onOpenAd: (ListingItem) -> Unit,
    header: (@Composable () -> Unit)? = null
) {
    if (ads.isEmpty()) return

    header?.let { headerContent ->
        item(
            key = "${keyPrefix}_header",
            contentType = SearchScreenDefaults.CT_HEADER,
            span = { GridItemSpan(maxLineSpan) }) {
            headerContent()
        }
    }

    items(
        items = ads,
        key = { it.id },
        contentType = { SearchScreenDefaults.CT_LISTING }
    ) { ad ->
        ListingRow(ad) {
            onOpenAd(ad)
        }
    }
}




@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun ContentListPreview() {
    MaterialTheme {
        ContentList(
            state = SearchUiState(
                searchQuery = "bike",
                resultAds = MockData.mockListingItems,
                isEmptyHintVisible = false
            ),
            onOpenAd = {},
            onRetry = {},
            onQuickQuery = {}
        )
    }
}
