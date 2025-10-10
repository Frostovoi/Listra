package com.example.reset.di

import androidx.lifecycle.ViewModel
import com.example.di.ViewModelKey
import com.example.reset.ResetViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ResetViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ResetViewModel::class)
    fun bindSearchViewModel(viewModel: ResetViewModel): ViewModel
}