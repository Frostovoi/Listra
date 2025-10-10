package com.example.register.di

import androidx.lifecycle.ViewModel
import com.example.di.ViewModelKey
import com.example.register.RegisterViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface RegisterViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    fun bindSearchViewModel(viewModel: RegisterViewModel): ViewModel
}