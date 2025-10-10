package com.example.login.di

import androidx.lifecycle.ViewModel
import com.example.di.ViewModelKey
import com.example.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface LoginViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun bindSearchViewModel(viewModel: LoginViewModel): ViewModel
}