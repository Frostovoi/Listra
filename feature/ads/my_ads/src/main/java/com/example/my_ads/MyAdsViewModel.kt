package com.example.my_ads

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.models.ListingItem
import com.example.api.repository.AdsRepository
import com.example.api.models.ListingTab
import com.example.api.models.states.MyAdsUiState
import com.example.network.utils.doOnSuccess
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MyAdsViewModel"

class MyAdsViewModel @Inject constructor(private val repository: AdsRepository) : ViewModel() {

    private var _uiState by mutableStateOf(MyAdsUiState())
    val uiState: MyAdsUiState
        get() = _uiState


    fun onTabChange(tab: ListingTab) {
        _uiState = _uiState.copy(currentTab = tab, isLoading = true)
        viewModelScope.launch {
            repository.loadAds(tab)
                .doOnSuccess {
                    _uiState = _uiState.copy(ads = it, isLoading = false)
            }

        }

    }
}