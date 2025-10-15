package com.example.listra.di

import android.app.Application
import com.example.ads_repo.di.AdsNetworkModule
import com.example.ads_repo.di.AdsRepositoryModule
import com.example.di.di.ViewModelFactoryModule
import com.example.identity_google.di.GoogleCredentialModule
import com.example.listra.App
import com.example.listra.MainActivity
import com.example.network.di.NetworkModule
import com.example.search_repo.di.SearchNetworkModule
import com.example.search_repo.di.SearchRepositoryModule
import com.example.search_screen.di.SearchDataStoreModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NavigatorModule::class,
        FeatureModulesAggregator::class,
        NetworkModule::class,
        ViewModelFactoryModule::class,
        SearchDataStoreModule::class,
        RepositoryModulesAggregator::class,
        GoogleCredentialModule::class
    ]
)
interface AppComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }
}