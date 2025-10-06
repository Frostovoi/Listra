package com.example.my_ads

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.api.models.ListingItem
import com.example.api.models.ListingStatus
import com.example.api.models.states.MyAdsUiState
import com.example.navigation.Destinations
import com.example.navigation.FeatureEntry
import com.example.navigation.Navigator
import java.time.LocalDate
import javax.inject.Inject


class MyAdsEntry @Inject constructor(
    private val vmFactory: ViewModelProvider.Factory
): FeatureEntry {

    override val featureRoute = Destinations.MyAds.route

    @RequiresApi(Build.VERSION_CODES.O)
    override fun register(builder: NavGraphBuilder, navigator: Navigator) {
        builder.composable(route = featureRoute) {
            MyAdsHost(
                vmFactory = vmFactory,
                backStackEntry = it,
                onOpenAd = { },
                onAddNewAdClick = { }
            )
        }
    }
}