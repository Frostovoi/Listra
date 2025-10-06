package com.example.navigation

sealed interface Destinations {
    val route: String

    data object Search: Destinations{ override val route = "search" }
    data object MyAds : Destinations { override val route = "my_ads" }
    data object PostAd : Destinations { override val route = "post_ad" }
    data object Auth : Destinations { override val route = "auth" }
    data object Details : Destinations {
        override val route = "details/{id}"
        fun build(id: String) = "details/$id"
        const val ARG_ID = "id"
    }


}