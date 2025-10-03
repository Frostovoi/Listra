package com.example.listra

import androidx.navigation.NavHostController
import com.example.navigation.Navigator
import javax.inject.Inject

class AppNavigator @Inject constructor() : Navigator {
    lateinit var controller: NavHostController


    override fun navigate(route: String) {
        controller.navigate(route)
    }

    override fun pop() {
        controller.popBackStack()
    }
}