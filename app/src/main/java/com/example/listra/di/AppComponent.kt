package com.example.listra.di

import android.app.Application
import com.example.listra.App
import com.example.listra.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [NavigatorModule::class, FeatureModulesAggregator::class ]

)
interface AppComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }
}