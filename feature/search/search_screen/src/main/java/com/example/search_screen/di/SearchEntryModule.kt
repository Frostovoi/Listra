package com.example.search_screen.di

import com.example.navigation.FeatureEntry
import com.example.search_screen.SearchEntry
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface SearchEntryModule {
    @Binds
    @IntoMap
    @StringKey("search")
    fun bindEntry(entry: SearchEntry) : FeatureEntry
}