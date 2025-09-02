package com.example.api.models

import java.time.LocalDate

data class ListingItem (
    val id: String,
    val title: String,
    val price: String,
    val imageUrl: String?,
    val location: String,
    val status: ListingStatus,
    val date: LocalDate
)