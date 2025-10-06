package com.example.search_repo.di

import com.example.api.repository.SearchRepository
import com.example.search_repo.SearchRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface SearchRepositoryModule {
    @Singleton
    @Binds
    fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository
}