package com.example.my_ads.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.api.models.ListingItem
import com.example.my_ads.list.card.ListingCard

@Composable
fun AdsList(
    ads: List<ListingItem>,
    onOpenAd: (ListingItem) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp),
    ) {
        items(items = ads, key = { it.id }) { ad ->
            ListingCard(
                ad = ad,
                onOpen = { onOpenAd(ad) }
            )
            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
        }
        item { Spacer(Modifier.height(64.dp)) }
    }
}



