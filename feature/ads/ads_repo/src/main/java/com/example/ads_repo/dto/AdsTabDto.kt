package com.example.ads_repo.dto

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.api.models.ListingItem
import kotlinx.serialization.Serializable

@Serializable
data class AdsTabDto(
  val ads: List<ListingItemDto>
){
    @RequiresApi(Build.VERSION_CODES.O)
    fun toAdsList() : List<ListingItem> = ads.map { it.toListingItem() }
}