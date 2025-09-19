package com.example.listra.di

import android.app.Application
import com.example.ads_repo.di.AdsNetworkModule
import com.example.ads_repo.di.AdsRepositoryModule
import com.example.di.di.ViewModelFactoryModule
import com.example.listra.App
import com.example.listra.MainActivity
import com.example.network.di.NetworkModule
import com.example.search_repo.di.SearchNetworkModule
import com.example.search_repo.di.SearchRepositoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NavigatorModule::class, FeatureModulesAggregator::class, AdsRepositoryModule::class, SearchRepositoryModule::class,
        NetworkModule::class, AdsNetworkModule::class, SearchNetworkModule::class, ViewModelFactoryModule::class]
)
interface AppComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }
}