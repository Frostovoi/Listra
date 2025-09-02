package com.example.my_ads

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.my_ads.list.AdsList
import com.example.my_ads.models.ListingItem
import com.example.my_ads.models.MyAdsUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAdsScreen(
    state: MyAdsUiState,
    onAddNewAdClick: () -> Unit,
    onOpenAd: (ListingItem) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Мои объявления") },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddNewAdClick
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add new item"
                )
            }
        }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            AdsList(
                ads = state.listingItems,
                onOpenAd = onOpenAd
            )

        }

    }
}


@Preview
@Composable
fun MyAdsScreenPreview(){

}
