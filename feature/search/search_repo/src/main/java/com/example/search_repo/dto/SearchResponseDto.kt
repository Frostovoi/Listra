package com.example.search_repo.dto


import android.os.Build
import androidx.annotation.RequiresApi
import com.example.api.models.ListingItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponseDto(
    val ads: List<ListingItemDto>,
    val page: Int,
    @SerialName("page_size") val pageSize: Int,
    val total: Int
) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun toSearchResponseList(): List<ListingItem> {
        return ads.map { it.toListingItem() }
    }
}
