package com.example.login

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.identity_api.GoogleIdentityProvider
import com.example.navigation.Destinations
import com.example.navigation.FeatureEntry
import com.example.navigation.Navigator
import javax.inject.Inject

class LoginEntry @Inject constructor(
    private val vmFactory: ViewModelProvider.Factory,
    private val googleIdentity: GoogleIdentityProvider
): FeatureEntry {
    override val featureRoute: String
        get() = Destinations.Login.route

    override fun register(
        builder: NavGraphBuilder,
        navigator: Navigator
    ) {
        builder.composable(route = featureRoute) {
            LoginHost(
                backStackEntry = it,
                vmFactory = vmFactory,
                googleIdentity = googleIdentity,
                onOpenForgot = {},
                onOpenSignUp = { navigator.navigate(Destinations.Register.route) },
            )
        }
    }
}