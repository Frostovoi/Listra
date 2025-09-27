package com.example.search_screen

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.api.models.ListingItem
import com.example.api.models.ListingStatus
import com.example.api.models.states.SearchUiState
import java.time.LocalDate

object MockData {

    @RequiresApi(Build.VERSION_CODES.O)
    val mockListingItems = listOf(
        ListingItem(
            id = "1",
            title = "Шоссейный велосипед Trek Domane",
            price = "1200 €",
            imageUrl = "https://picsum.photos/200/300",
            location = "Berlin",
            status = ListingStatus.ACTIVE,
            date = LocalDate.now().minusDays(1)
        ),
        ListingItem(
            id = "2",
            title = "Горный велосипед Specialized Rockhopper",
            price = "900 €",
            imageUrl = "https://picsum.photos/200/301",
            location = "Munich",
            status = ListingStatus.ARCHIVED,
            date = LocalDate.now().minusDays(10)
        ),
        ListingItem(
            id = "3",
            title = "Городской велосипед Cannondale Quick",
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
            id = "4",
            title = "Шоссейный велосипед Trek Domane",
            price = "1200 €",
            imageUrl = "https://picsum.photos/200/300",
            location = "Berlin",
            status = ListingStatus.ACTIVE,
            date = LocalDate.now().minusDays(1)
        ),
        ListingItem(
            id = "5",
            title = "Горный велосипед Specialized Rockhopper",
            price = "900€",
            imageUrl = "https://picsum.photos/200/301",
            location = "Munich",
            status = ListingStatus.ARCHIVED,
            date = LocalDate.now().minusDays(10)
        ),
        ListingItem(
            id = "6",
            title = "Городской велосипед Cannondale Quick",
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