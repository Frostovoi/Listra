package com.example.search_screen.ui

import android.os.Build
import com.example.search_screen.R as SearchR
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.PagingData
import com.example.api.models.ListingItem
import com.example.api.models.states.SearchUiState
import com.example.search_screen.utils.MockData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    state: SearchUiState,
    onSearchQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
    onBack: () -> Unit,
    onOpenAd: (ListingItem) -> Unit,
    pagingFlow: Flow<PagingData<ListingItem>>
) {
    val focus = LocalFocusManager.current
    var expanded by rememberSaveable { mutableStateOf(false) }
    val searchQuery = state.searchQuery

    val handleBack: () -> Unit = {
        when {
            // Close hints
            expanded -> {
                expanded = false
                focus.clearFocus()
            }
            // Clear query
            searchQuery.isNotBlank() -> {
                onSearchQueryChange("")
                focus.clearFocus()
            }
            // Back from the page
            else -> {
                onBack()
            }
        }
    }

    BackHandler(enabled = true) { handleBack() }

    Scaffold { paddingValues ->
        Column(Modifier
            .fillMaxSize()
            .padding(paddingValues))
        {
            SearchBar(
                modifier = Modifier.fillMaxWidth(),
                expanded = expanded,
                onExpandedChange = { expanded = it },
                inputField = {
                    TextField(
                        value = searchQuery,
                        onValueChange = {
                            onSearchQueryChange(it)
                            if (!expanded) expanded = true
                        },
                        singleLine = true,
                        placeholder = { Text(
                            text = stringResource( id = SearchR.string.search_placeholder)
                        )},
                        leadingIcon = {
                            // Back Button
                            IconButton(onClick = handleBack) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = stringResource(
                                        id = SearchR.string.search_back_cd
                                    )
                                )
                            }
                        },
                        trailingIcon = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                if (searchQuery.isNotBlank()) {
                                    // Clear Button
                                    IconButton(onClick = { onSearchQueryChange("") }) {
                                        Icon(
                                            imageVector = Icons.Default.Clear,
                                            contentDescription = stringResource(
                                                id = SearchR.string.search_clear_cd
                                            )
                                        )
                                    }
                                }
                                // Filters Button
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Filled.FilterList,
                                        contentDescription = stringResource(
                                            id = SearchR.string.search_filters_cd
                                        )
                                    )
                                }
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Search,
                            capitalization = KeyboardCapitalization.Sentences
                        ),
                        keyboardActions = KeyboardActions(
                            onSearch = {
                                onSearch()
                                focus.clearFocus()
                                expanded = false
                            }
                        )
                    )
                },
                content = {
                    if (expanded) {
                        SuggestionsAndHistory(
                            history = state.history,
                            onPick = { text ->
                                onSearchQueryChange(text)
                                onSearch()
                                expanded = false
                                focus.clearFocus()
                            },
                            onClearHistory = { }
                        )
                    }
                }
            )

            ContentListPaging(
                onOpenAd = onOpenAd,
                pagingFlow = pagingFlow
            )
        }
    }
}


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


