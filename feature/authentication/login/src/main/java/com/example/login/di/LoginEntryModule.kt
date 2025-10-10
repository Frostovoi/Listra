package com.example.login.di

import com.example.login.LoginEntry
import com.example.navigation.FeatureEntry
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey


@Module
interface LoginEntryModule {
    @Binds
    @IntoMap
    @StringKey("login")
    fun bindEntry(entry: LoginEntry) : FeatureEntry
}