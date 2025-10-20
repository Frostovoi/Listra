package com.example.register.di

import com.example.navigation.FeatureEntry
import com.example.register.RegisterEntry
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface RegisterEntryModule {
    @Binds
    @IntoMap
    @StringKey("register")
    fun bindEntry(entry: RegisterEntry) : FeatureEntry
}