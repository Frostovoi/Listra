package com.example.navigation

import androidx.navigation.NavGraphBuilder

interface FeatureEntry {

    val featureRoute: String

    fun register(builder: NavGraphBuilder, navigator: Navigator)
}