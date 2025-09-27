package com.example.search_repo.dto

import com.example.api.models.ListingItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponseDto(
    val ads: List<ListingItem>,
    val page: Int,
    @SerialName("page_size") val pageSize: Int,
    val total: Int
)
