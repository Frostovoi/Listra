package com.example.post_ad

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.Destinations
import com.example.navigation.FeatureEntry
import com.example.navigation.Navigator
import javax.inject.Inject


class PostAdEntry @Inject constructor(): FeatureEntry {

    override val featureRoute = Destinations.PostAd.route

    override fun register(
        builder: NavGraphBuilder,
        navigator: Navigator
    ) {
        builder.composable(route = featureRoute) {
            PostAdScreen()
        }
    }


}