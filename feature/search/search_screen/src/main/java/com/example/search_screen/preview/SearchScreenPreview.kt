package com.example.search_screen.preview

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.search_screen.ui.ErrorRow
import com.example.search_screen.ui.SearchScreen
import com.example.search_screen.utils.MockData
import kotlinx.coroutines.flow.emptyFlow


@Preview
@Composable
fun ErrorRowPreview() {
    MaterialTheme {
        ErrorRow(message = "Ошибка", onRetry = {})
    }
}


@Preview
@Composable
fun SearchScreenWithStateLoading() {
    MaterialTheme {
        SearchScreen(
            state = MockData.previewStateLoading,
            onSearchQueryChange = {},
            onSearch = {},
            onBack = {},
            onOpenAd = {},
            pagingFlow = emptyFlow()
        )
    }
}


@Preview
@Composable
fun SearchScreenWithStateError() {
    MaterialTheme {
        SearchScreen(
            state = MockData.previewStateError,
            onSearchQueryChange = {},
            onSearch = {},
            onBack = {},
            onOpenAd = {},
            pagingFlow = emptyFlow()
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun SearchScreenWithHistory() {
    MaterialTheme {
        SearchScreen(
            state = MockData.previewStateWithHistory,
            onSearchQueryChange = {},
            onSearch = {},
            onBack = {},
            onOpenAd = {},
            pagingFlow = emptyFlow()
        )
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun SearchScreenWithResults() {
    MaterialTheme {
        SearchScreen(
            state = MockData.previewStateWithResults,
            onSearchQueryChange = {},
            onSearch = {},
            onBack = {},
            onOpenAd = {},
            pagingFlow = emptyFlow()
        )
    }
}