package com.example.ad_details.di

import com.example.ad_details.DetailsEntry
import com.example.navigation.FeatureEntry
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class DetailsEntryModule {
    @Binds
    @IntoMap
    @StringKey("details")
    abstract fun bindEntry(entry: DetailsEntry) : FeatureEntry
}