package com.example.listra.di

import com.example.ad_details.di.DetailsEntryModule
import com.example.login.di.LoginEntryModule
import com.example.login.di.LoginViewModelModule
import com.example.my_ads.di.MyAdsEntryModule
import com.example.my_ads.di.MyAdsViewModelModule
import com.example.post_ad.di.PostAdEntryModule
import com.example.profile.di.ProfileEntryModule
import com.example.register.di.RegisterEntryModule
import com.example.register.di.RegisterViewModelModule
import com.example.reset.di.ResetEntryModule
import com.example.reset.di.ResetViewModelModule
import com.example.search_screen.di.SearchEntryModule
import com.example.search_screen.di.SearchViewModelModule
import dagger.Module


@Module(
    includes = [
        MyAdsEntryModule::class, MyAdsViewModelModule::class,
        SearchEntryModule::class, SearchViewModelModule::class,
        PostAdEntryModule::class,
        DetailsEntryModule::class,
        ProfileEntryModule::class,
        LoginEntryModule::class, LoginViewModelModule::class,
        ResetEntryModule::class, ResetViewModelModule::class,
        RegisterEntryModule::class, RegisterViewModelModule::class,
    ]
)
object FeatureModulesAggregator