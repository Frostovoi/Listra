package com.example.navigation

sealed interface Destinations {
    val route: String

    data object Search: Destinations{ override val route = "search" }
    data object MyAds : Destinations { override val route = "my_ads" }
    data object PostAd : Destinations { override val route = "post_ad" }
    data object Login : Destinations { override val route = "login" }
    data object Register : Destinations { override val route = "register" }
    data object Reset : Destinations { override val route = "reset" }

    data object Details : Destinations {
        override val route = "details/{id}"
        fun build(id: String) = "details/$id"
        const val ARG_ID = "id"
    }


}