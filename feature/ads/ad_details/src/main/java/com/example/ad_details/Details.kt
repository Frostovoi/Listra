package com.example.ad_details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DetailsScreen(id: String?) {
    Scaffold { paddingValues ->
        Text(
            text = "Details Screen",
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .wrapContentSize()
        )
    }
}