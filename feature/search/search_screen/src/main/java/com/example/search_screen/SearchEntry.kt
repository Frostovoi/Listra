package com.example.search_screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.Destinations
import com.example.navigation.FeatureEntry
import com.example.navigation.Navigator
import javax.inject.Inject
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModelProvider

class SearchEntry @Inject constructor(
    private val vmFactory: ViewModelProvider.Factory
): FeatureEntry{
    override val featureRoute: String
        get() = Destinations.Search.route

    override fun register(
        builder: NavGraphBuilder,
        navigator: Navigator
    ) {
        builder.composable(route = featureRoute) {
            SearchHost(
                vmFactory = vmFactory,
                backStackEntry = it,
                onOpenAd = {}
            )

        }
    }

}