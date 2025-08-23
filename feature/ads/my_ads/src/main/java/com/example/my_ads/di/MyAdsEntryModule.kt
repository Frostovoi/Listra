package com.example.my_ads.di

import com.example.my_ads.MyAdsEntry
import com.example.navigation.FeatureEntry
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class MyAdsEntryModule {

    @Binds
    @IntoMap
    @StringKey("my_ads")
    abstract fun bindEntry(entry: MyAdsEntry) : FeatureEntry
}