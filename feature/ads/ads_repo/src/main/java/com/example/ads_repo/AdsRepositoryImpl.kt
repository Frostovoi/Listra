package com.example.ads_repo

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.ads_repo.api.AdsTabApi
import com.example.api.models.ListingItem
import com.example.api.models.ListingTab
import com.example.api.repository.AdsRepository
import com.example.network.utils.Result
import com.example.network.utils.mapSuccess
import com.example.network.utils.runOperationCatching
import com.example.network.utils.safeApiCall
import javax.inject.Inject


class AdsRepositoryImpl @Inject constructor(private val adsTabApi: AdsTabApi) : AdsRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun loadAds(tab: ListingTab): Result<List<ListingItem>, Throwable> {
        return runOperationCatching { adsTabApi.getAds(tab.name).toAdsList() }

    }
}