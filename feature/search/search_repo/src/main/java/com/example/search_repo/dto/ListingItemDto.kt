package com.example.search_repo.dto

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.api.models.ListingItem
import com.example.api.models.ListingStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class ListingItemDto(
    val id: String,
    val title: String,
    val price: String,
    val location: String,
    @SerialName("image_url") val imageUrl: String? = null,
    val date: String,
    val status: ListingStatus = ListingStatus.ACTIVE
) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun toListingItem(): ListingItem {
        return ListingItem(
            id = id,
            title = title,
            price = price,
            location = location,
            imageUrl = imageUrl,
            date = LocalDate.parse(date),
            status = status
        )
    }
}
