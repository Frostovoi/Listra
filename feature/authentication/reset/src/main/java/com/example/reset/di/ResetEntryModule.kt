package com.example.reset.di

import com.example.navigation.FeatureEntry
import com.example.reset.ResetEntry
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface ResetEntryModule {
    @Binds
    @IntoMap
    @StringKey("reset")
    fun bindEntry(entry: ResetEntry) : FeatureEntry
}