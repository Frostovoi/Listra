package com.example.ads_repo.api

import com.example.ads_repo.dto.AdsTabDto
import retrofit2.http.GET
import retrofit2.http.Path

interface AdsTabApi {

    @GET("/{listingTab}")
    suspend fun getAds(@Path("listingTab") listingTab: String): AdsTabDto


    @GET("connect")
    suspend fun connect(): String
}