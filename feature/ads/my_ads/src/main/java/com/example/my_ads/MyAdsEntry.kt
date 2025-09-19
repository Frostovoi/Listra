package com.example.my_ads

import android.os.Build
import androidx.annotation.RequiresApi
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


class MyAdsEntry @Inject constructor(private val viewModel: MyAdsViewModel): FeatureEntry {

    override val featureRoute = Destinations.MyAds.route

    @RequiresApi(Build.VERSION_CODES.O)
    override fun register(builder: NavGraphBuilder, navigator: Navigator) {
        builder.composable(route = featureRoute) {
            MyAdsScreen(
                state = viewModel.uiState,
                onAddNewAdClick = {},
                onOpenAd = {},
                onTabChange = viewModel::onTabChange
            )
        }
    }
}