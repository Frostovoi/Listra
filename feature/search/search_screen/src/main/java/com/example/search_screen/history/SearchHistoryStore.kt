package com.example.search_screen.history



import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import com.example.search_screen.utils.SearchScreenDefaults as SSD
import kotlinx.serialization.json.Json
import javax.inject.Inject

class SearchHistoryStore @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    private val json: Json
) {
    private val KEY = stringPreferencesKey(SSD.PREF_KEY_HISTORY)

    val historyFlow: Flow<List<String>> = dataStore.data.map { prefs ->
        prefs[KEY]?.let { runCatching {
            json.decodeFromString<List<String>>(it)
        }.getOrNull() } ?: emptyList()
    }

    suspend fun addQuery(query: String, max: Int = 10) {
        val clean = query.trim().trim()
        if (clean.isEmpty()) return
        dataStore.edit { prefs ->
            val current = prefs[KEY]?.let { runCatching {
                json.decodeFromString<List<String>>(it)
            }.getOrNull() }.orEmpty()

            val updated = (listOf(clean) + current).distinct().take(max)
            prefs[KEY] = json.encodeToString(updated)
        }
    }


    suspend fun clear() {
        dataStore.edit { it.remove(KEY) }
    }
}