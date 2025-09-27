package com.example.search_repo.api

import com.example.search_repo.dto.SearchResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("/search")
    suspend fun searchAds(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int
    ): SearchResponseDto

}