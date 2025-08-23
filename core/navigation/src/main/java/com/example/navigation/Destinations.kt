package com.example.navigation

sealed interface Destinations {
    val route: String

    data object MyAds : Destinations {
        override val route = "my_ads"
    }
}