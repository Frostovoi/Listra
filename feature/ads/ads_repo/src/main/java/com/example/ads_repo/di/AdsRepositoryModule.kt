package com.example.ads_repo.di

import com.example.ads_repo.AdsRepository
import com.example.ads_repo.AdsRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface AdsRepositoryModule {

    @Singleton
    @Binds
    fun bindAdsRepository(impl: AdsRepositoryImpl): AdsRepository

}