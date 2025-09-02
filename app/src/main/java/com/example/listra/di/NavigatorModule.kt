package com.example.listra.di

import com.example.listra.AppNavigator
import com.example.navigation.Navigator
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface NavigatorModule {

    @Singleton
    @Binds
    fun bindNavigator(navigator: AppNavigator) : Navigator
}