package com.example.auth.di

import com.example.auth.AuthEntry
import com.example.navigation.FeatureEntry
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class AuthEntryModule {
    @Binds
    @IntoMap
    @StringKey("auth")
    abstract fun bindEntry(entry: AuthEntry) : FeatureEntry
}