package com.example.search_screen.di

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.search_screen.history.SearchHistoryStore
import com.example.search_screen.utils.SearchScreenDefaults as SSD
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import javax.inject.Singleton


@Module
object SearchDataStoreModule {
    @Provides
    @Singleton
    fun provideSearchDataStore(app: Application): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = {
                app.preferencesDataStoreFile(SSD.PREF_KEY_HISTORY)
            }
        )
    }

    @Provides
    @Singleton
    fun provideSearchHistoryStore(
        ds: DataStore<Preferences>,
        json: Json
    ): SearchHistoryStore = SearchHistoryStore(ds, json)
}