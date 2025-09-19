package com.example.search_screen

import androidx.navigation.NavGraphBuilder
import com.example.navigation.Destinations
import com.example.navigation.FeatureEntry
import com.example.navigation.Navigator
import javax.inject.Inject

class SearchEntry @Inject constructor(): FeatureEntry{
    override val featureRoute: String
        get() = Destinations.Search.route

    override fun register(
        builder: NavGraphBuilder,
        navigator: Navigator
    ) {

    }

}