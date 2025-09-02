package com.example.my_ads.models

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