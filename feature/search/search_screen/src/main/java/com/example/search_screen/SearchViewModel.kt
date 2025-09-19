package com.example.search_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.models.states.SearchUiState
import com.example.api.repository.SearchRepository
import com.example.network.utils.doOnSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val searchRepository: SearchRepository): ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState>
        get() = _uiState.asStateFlow()

    fun onSearchQueryChange(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query, isLoading = true)
        viewModelScope.launch {
            searchRepository.searchAds(query)
                .doOnSuccess {
                    _uiState.value = _uiState.value.copy(ads = it, isLoading = false)
            }
        }
    }
}