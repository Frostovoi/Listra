package com.example.di.di

import androidx.lifecycle.ViewModelProvider
import com.example.di.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {
    @Binds
    fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}