package com.example.my_ads

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.api.models.ListingItem
import com.example.api.models.ListingStatus
import com.example.api.models.ListingTab
import com.example.api.states.MyAdsUiState
import com.example.my_ads.tabs.MyAdsTabs
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAdsScreen(
    state: MyAdsUiState,
    onAddNewAdClick: () -> Unit,
    onOpenAd: (ListingItem) -> Unit,
    onTabChange: (ListingTab) -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
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
            MyAdsTabs(
                selected = state.currentTab,
                onTabChange = onTabChange,
                onOpenAd = onOpenAd,
                ads = state.ads
            )
        }

    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun MyAdsScreenPreview(){
    val ad = ListingItem(
        id = "1",
        title = "Телефон Телефон Телефон Телефон Телефон Телефон Телефон Телефон Телефон Телефон Телефон Телефон Телефон ",
        price = "115000",
        imageUrl = null,
        location = "Москва, asjbdalfskdfhsdfbsdfsfsbjdfsdfdsfdsfsdfdsfsd",
        status = ListingStatus.ACTIVE,
        date = LocalDate.now(),
    )
    val ads = List(10){ad.copy(id = "$it")}
    MaterialTheme{
        MyAdsScreen(
            state = MyAdsUiState(ads = ads),
            onAddNewAdClick = {},
            onOpenAd = {},
            onTabChange = {}
        )
    }
}
