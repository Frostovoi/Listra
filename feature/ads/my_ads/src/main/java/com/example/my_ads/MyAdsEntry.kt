package com.example.my_ads

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.Destinations
import com.example.navigation.FeatureEntry
import com.example.navigation.Navigator
import javax.inject.Inject


class MyAdsEntry @Inject constructor(): FeatureEntry {

    override val featureRoute = Destinations.MyAds.route

    override fun register(builder: NavGraphBuilder, navigator: Navigator) {
        builder.composable(route = featureRoute) {
            MyAdsScreen()
        }
    }
}