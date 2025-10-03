package com.example.listra

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.listra.FeatureRegistry
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: AppNavigator
    @Inject
    lateinit var registry: FeatureRegistry
    @Inject
    lateinit var viwModelFactory: ViewModelProvider.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            LaunchedEffect(Unit) {
                navigator.controller = navController
            }

            MaterialTheme{
                AppRoot(
                    navController = navController,
                    navigator = navigator,
                    registry = registry
                )
            }
        }
    }
}