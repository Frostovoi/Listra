package com.example.search_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.models.states.SearchUiState
import com.example.api.repository.SearchRepository
import com.example.network.utils.doOnError
import com.example.network.utils.doOnSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val repository: SearchRepository): ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState>
        get() = _uiState.asStateFlow()


    fun onSearchSubmit() {
        val query = _uiState.value.searchQuery.trim()
        if (query.isEmpty()) {
            _uiState.update { it.copy(resultAds = emptyList(),isEmptyHintVisible = true) }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null, isEmptyHintVisible = false) }
            repository.searchAds(query).doOnSuccess { ads ->
                _uiState.update { it.copy(
                    resultAds = ads,
                    isLoading = false,
                    error = null,
                    history = (listOf(query) + it.history).distinct().take(10)
                ) }
            }.doOnError { error ->
                _uiState.update { it.copy(
                    error = error.message,
                    isLoading = false,
                    resultAds = emptyList()
                ) }
            }
        }
    }

    fun onSearchQueryChange(query: String) {
        _uiState.update {
            it.copy(
                searchQuery = query,
                isEmptyHintVisible = query.isEmpty(),
                error = null
            )
        }
    }
}