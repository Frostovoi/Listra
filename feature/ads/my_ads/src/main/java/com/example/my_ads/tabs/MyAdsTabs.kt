package com.example.my_ads.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.api.models.ListingItem
import com.example.api.models.ListingTab
import com.example.my_ads.list.AdsList
import kotlinx.coroutines.launch

@Composable
fun MyAdsTabs(
    selected: ListingTab,
    onTabChange: (ListingTab) -> Unit,
    onOpenAd: (ListingItem) -> Unit,
    ads: List<ListingItem>
) {
    val tabs = ListingTab.entries.toTypedArray()
    val labels = mapOf(
        ListingTab.Active to "Active",
        ListingTab.Archived to "Archived",
        ListingTab.Drafts to "Drafts"
    )
    val selectedIndex = tabs.indexOf(selected)
    val pagerState = rememberPagerState(initialPage = selectedIndex, pageCount = { tabs.size })
    val scope = rememberCoroutineScope()

    Column {
        TabRow(selectedTabIndex = selectedIndex) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = index == selectedIndex,
                    onClick = {
                        onTabChange(tab)
                        scope.launch { pagerState.animateScrollToPage(index) }
                    },
                    text = { labels[tab]?.let { Text(it) } }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            onTabChange(tabs[page])
            AdsList(ads = ads, onOpenAd = onOpenAd)}
    }
}