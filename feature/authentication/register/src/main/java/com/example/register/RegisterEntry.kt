package com.example.register

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.Destinations
import com.example.navigation.FeatureEntry
import com.example.navigation.Navigator
import javax.inject.Inject

class RegisterEntry @Inject constructor(
    private val vmFactory: ViewModelProvider.Factory
): FeatureEntry {
    override val featureRoute: String
        get() = Destinations.Register.route

    override fun register(
        builder: NavGraphBuilder,
        navigator: Navigator
    ) {
        builder.composable(route = featureRoute) {
            RegisterHost()
        }
    }
}