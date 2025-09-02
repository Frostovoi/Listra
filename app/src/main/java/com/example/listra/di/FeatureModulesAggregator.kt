package com.example.listra.di

import com.example.ad_details.di.DetailsEntryModule
import com.example.auth.di.AuthEntryModule
import com.example.my_ads.di.MyAdsEntryModule
import com.example.post_ad.di.PostAdEntryModule
import com.example.profile.di.ProfileEntryModule
import dagger.Module


@Module(
    includes = [
        MyAdsEntryModule::class,
        PostAdEntryModule::class,
        DetailsEntryModule::class,
        ProfileEntryModule::class,
        AuthEntryModule::class,
    ]
)
object FeatureModulesAggregator