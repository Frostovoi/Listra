package com.example.search_repo.di

import com.example.search_repo.api.SearchApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object SearchNetworkModule {
    @Provides
    @Singleton
    fun provideAdsApi(retrofit: Retrofit): SearchApi = retrofit.create(SearchApi::class.java)
}