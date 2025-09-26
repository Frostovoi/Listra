package com.example.listra

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.navigation.Destinations
import com.example.navigation.Navigator

@Composable
fun AppRoot(
    navController: NavHostController,
    navigator: Navigator,
    registry: FeatureRegistry
) {
   NavHost(
       navController = navController,
       startDestination = Destinations.Search.route
   ) {
       registry.registerAll(builder = this, navigator = navigator)
   }
}