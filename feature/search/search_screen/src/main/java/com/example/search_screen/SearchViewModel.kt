package com.example.search_screen


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.api.models.ListingItem
import com.example.api.models.states.SearchUiState
import com.example.api.repository.SearchRepository
import com.example.search_screen.history.SearchHistoryStore
import com.example.search_screen.paging.asPager
import com.example.search_screen.utils.MockData
import com.example.search_screen.utils.SearchScreenDefaults as SSD
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.debounce
import javax.inject.Inject
@RequiresApi(Build.VERSION_CODES.O)
class  SearchViewModel @Inject constructor(
    private val repository: SearchRepository,
    private val historyStore: SearchHistoryStore
): ViewModel() {


    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState>
        get() = _uiState.asStateFlow()


    // History from DataStore
    val history: StateFlow<List<String>> =
        historyStore.historyFlow.stateIn(
            viewModelScope, SharingStarted.Lazily, emptyList()
        )

    // Search trigger
    private val searchRequests = MutableSharedFlow<String>(extraBufferCapacity = 1)


    // UI Flow
    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    val pagingFlow: Flow<PagingData<ListingItem>> =
        searchRequests
            .debounce(SSD.DEBOUNCE_TIME)
            .map(String::trim)
            .filter { it.length >= SSD.FILTER_LENGTH }
            .distinctUntilChanged()
            .flatMapLatest { q ->
                if (q.isBlank()){
                    flowOf(PagingData.empty())
                }
                else {
                    repository.asPager(q, pageSize = SSD.PAGE_SIZE)
                }
            }
            .cachedIn(viewModelScope)



    fun onSearchSubmit() {
        val query = _uiState.value.searchQuery.trim()

        if (query.isEmpty()) {
            // Clear results and show hints
            _uiState.update { it.copy(resultAds = emptyList(),isEmptyHintVisible = true) }
            return
        }

        viewModelScope.launch {
            historyStore.addQuery(query)
        }
        searchRequests.tryEmit(query)
        _uiState.update { it.copy(isEmptyHintVisible = false) }

    }

    fun onSearchQueryChange(query: String) {
        _uiState.update {
            it.copy(
                searchQuery = query,
                isEmptyHintVisible = query.isEmpty(), // show hint when query is blank
                error = null
            )
        }

        searchRequests.tryEmit(query)
    }

    fun onClearHistory() {
        viewModelScope.launch {
            historyStore.clear()
        }
    }
}
