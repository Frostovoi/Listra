package com.example.ad_details

import android.R.attr.type
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navigation.Destinations
import com.example.navigation.FeatureEntry
import com.example.navigation.Navigator
import javax.inject.Inject


class DetailsEntry @Inject constructor(): FeatureEntry {
    override val featureRoute: String
        get() = Destinations.Details.route

    override fun register(
        builder: NavGraphBuilder,
        navigator: Navigator
    ) {
        builder.composable(
            route = Destinations.Details.route,
            arguments = listOf(
                navArgument(Destinations.Details.ARG_ID) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString(Destinations.Details.ARG_ID)
            DetailsScreen(id = id)
        }
    }

}