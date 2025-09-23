package com.example.search_screen.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import com.example.api.models.ListingItem
import com.example.api.models.states.SearchUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    state: SearchUiState,
    onSearchQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
    onBack: () -> Unit,
    onOpenAd: (ListingItem) -> Unit
) {
    val focus = LocalFocusManager.current
    var expanded by rememberSaveable { mutableStateOf(false) }
    val searchQuery = state.searchQuery

    Scaffold { paddingValues ->
        Column(Modifier
            .fillMaxSize()
            .padding(paddingValues))
        {
            SearchBar(
                modifier = Modifier.fillMaxSize(),
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
                        placeholder = { Text("Search") },
                        leadingIcon = {
                            IconButton(onClick = onBack) {
                                Icon(
                                    Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        },
                        trailingIcon = {
                            if (searchQuery.isNotBlank()) {
                                IconButton(onClick = { onSearchQueryChange("") }) {
                                    Icon(Icons.Default.Clear, contentDescription = "Clear")
                                }
                            }
                            IconButton(onClick = {}) {
                                Icon(Icons.Filled.FilterList, contentDescription = "Filters")
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
                        SuggestionsAndHistory { }
                        BackHandler { expanded = false }
                    }
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
            )
            ContentList(
                state = state,
                onOpenAd = onOpenAd,
                onRetry = {
                    onSearch()
                    focus.clearFocus()
                }
            )
        }
    }
}