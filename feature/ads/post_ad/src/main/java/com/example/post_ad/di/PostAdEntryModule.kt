package com.example.post_ad.di

import com.example.navigation.FeatureEntry
import com.example.post_ad.PostAdEntry
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class PostAdEntryModule {
    @Binds
    @IntoMap
    @StringKey("post_ad")
    abstract fun bindEntry(entry: PostAdEntry) : FeatureEntry

}