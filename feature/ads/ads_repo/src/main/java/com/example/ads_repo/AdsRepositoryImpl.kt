package com.example.ads_repo

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.api.models.ListingItem
import com.example.api.models.ListingStatus
import com.example.api.models.ListingTab
import java.time.LocalDate
import javax.inject.Inject


class AdsRepositoryImpl @Inject constructor() : AdsRepository{

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun loadAds(tab: ListingTab): List<ListingItem> {
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
        val adsArchived = List(5){ad.copy(id = "1$it", status = ListingStatus.ARCHIVED)}
        val adsDraft = List(3){ad.copy(id = "2$it", status = ListingStatus.DRAFT)}

        return when (tab) {
            ListingTab.Active -> ads
            ListingTab.Archived -> adsArchived
            ListingTab.Drafts -> adsDraft
        }

    }

}