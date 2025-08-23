package com.example.listra

import androidx.navigation.NavGraphBuilder
import com.example.navigation.FeatureEntry
import com.example.navigation.Navigator
import javax.inject.Inject

class FeatureRegistry @Inject constructor(
    private val entries: Map<String, @JvmSuppressWildcards FeatureEntry>
) {

    fun registerAll(builder: NavGraphBuilder, navigator: Navigator) {
        entries.values.forEach{ it.register(builder, navigator)}
    }
}