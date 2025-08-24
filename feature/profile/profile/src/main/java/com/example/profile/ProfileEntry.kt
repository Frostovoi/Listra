package com.example.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.FeatureEntry
import com.example.navigation.Navigator

class ProfileEntry : FeatureEntry {
    override val featureRoute: String
        get() = "profile"

    override fun register(
        builder: NavGraphBuilder,
        navigator: Navigator
    ) {
        builder.composable(featureRoute) {
            ProfileScreen()
        }

    }


}