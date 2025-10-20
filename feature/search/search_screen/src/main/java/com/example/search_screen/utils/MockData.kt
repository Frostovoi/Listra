package com.example.search_screen.utils

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.api.models.ListingItem
import com.example.api.models.ListingStatus
import com.example.api.states.SearchUiState
import java.time.LocalDate

object MockData {

    @RequiresApi(Build.VERSION_CODES.O)
    val mockListingItems = listOf(
        ListingItem(
            id = "1",
            title = "Шоссейный",
            price = "1200 €",
            imageUrl = "https://picsum.photos/200/300",
            location = "Berlin",
            status = ListingStatus.ACTIVE,
            date = LocalDate.now().minusDays(1)
        ),
        ListingItem(
            id = "2",
            title = "Горный",
            price = "900 €",
            imageUrl = "https://picsum.photos/200/301",
            location = "Munich",
            status = ListingStatus.ARCHIVED,
            date = LocalDate.now().minusDays(10)
        ),
        ListingItem(
            id = "3",
            title = "Городской",
            price = "700 €",
            imageUrl = null, // без картинки
            location = "Hamburg",
            status = ListingStatus.DRAFT,
            date = LocalDate.now()
        )
    )

    @RequiresApi(Build.VERSION_CODES.O)
    val mockListingRecs = listOf(
        ListingItem(
            id = "51",
            title = "велосипед",
            price = "1200 €",
            imageUrl = "https://picsum.photos/200/300",
            location = "Berlin",
            status = ListingStatus.ACTIVE,
            date = LocalDate.now().minusDays(1)
        ),
        ListingItem(
            id = "52",
            title = "Горный велосипед",
            price = "900€",
            imageUrl = "https://picsum.photos/200/301",
            location = "Munich",
            status = ListingStatus.ARCHIVED,
            date = LocalDate.now().minusDays(10)
        ),
        ListingItem(
            id = "53",
            title = "Городской велосипед",
            price = "700 €",
            imageUrl = null, // без картинки
            location = "Hamburg",
            status = ListingStatus.DRAFT,
            date = LocalDate.now()
        )
    )

    val previewStateLoading = SearchUiState(
        isLoading = true,
        searchQuery = "bike"
    )

    @RequiresApi(Build.VERSION_CODES.O)
    val previewStateWithResults = SearchUiState(
        searchQuery = "bike",
        resultAds = mockListingItems,
        isEmptyHintVisible = false
    )

    @RequiresApi(Build.VERSION_CODES.O)
    val previewStateWithHistory = SearchUiState(
        history = listOf("phone", "car", "bike"),
        recommendations = mockListingItems.take(2)
    )

    val previewStateError = SearchUiState(
        searchQuery = "bike",
        error = "Что-то пошло не так",
        isEmptyHintVisible = false
    )
}