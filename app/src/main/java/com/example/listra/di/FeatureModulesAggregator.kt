package com.example.listra.di

import com.example.my_ads.di.MyAdsEntryModule
import dagger.Module


@Module(
    includes = [
        MyAdsEntryModule::class
    ]
)
object FeatureModulesAggregator {
}