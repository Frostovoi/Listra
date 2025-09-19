package com.example.my_ads.di

import androidx.lifecycle.ViewModel
import com.example.di.ViewModelKey
import com.example.my_ads.MyAdsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MyAdsViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MyAdsViewModel::class)
    fun bindMyAdsViewModel(viewModel: MyAdsViewModel): ViewModel
}