package com.example.listra.di

import com.example.ads_repo.di.AdsNetworkModule
import com.example.ads_repo.di.AdsRepositoryModule
import com.example.auth_repo.di.AuthNetworkModule
import com.example.auth_repo.di.AuthRepositoryModule
import com.example.search_repo.di.SearchNetworkModule
import com.example.search_repo.di.SearchRepositoryModule
import dagger.Module


@Module(
    includes = [
        AdsRepositoryModule::class,  AdsNetworkModule::class,
        SearchRepositoryModule::class, SearchNetworkModule::class,
        AuthRepositoryModule::class, AuthNetworkModule::class
    ]
)
object RepositoryModulesAggregator