package com.example.profile.di

import com.example.navigation.FeatureEntry
import com.example.profile.ProfileEntry
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class ProfileEntryModule {
    @Binds
    @IntoMap
    @StringKey("profile")
    abstract fun bindEntry(entry: ProfileEntry) : FeatureEntry
}