package com.example.search_repo.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListingItemDto(
    val id: String,
    val title: String,
    val price: String,
    val location: String,
    @SerialName("image_url") val imageUrl: String? = null,
    val date: String
)
