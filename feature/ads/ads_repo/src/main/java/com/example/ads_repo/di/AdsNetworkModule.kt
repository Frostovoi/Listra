package com.example.ads_repo.di

import com.example.ads_repo.api.AdsTabApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object AdsNetworkModule {
    @Provides
    @Singleton
    fun provideAdsApi(retrofit: Retrofit): AdsTabApi = retrofit.create(AdsTabApi::class.java)
}