package com.example.my_ads.tabs

import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.my_ads.models.ListingTab

@Composable
fun MyAdsTabs(
    selected: ListingTab,
    onSelect: (ListingTab) -> Unit
) {
    val tabs = ListingTab.entries.toTypedArray()
    val labels = mapOf(
        ListingTab.Active to "Active",
        ListingTab.Archived to "Archived",
        ListingTab.Drafts to "Drafts"
    )
    val selectedIndex = tabs.indexOf(selected)

    TabRow(selectedTabIndex = selectedIndex) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onSelect(tab) },
                text = { labels[tab]?.let { Text(it) } }
            )
        }
    }
}