package com.example.search_screen.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.api.models.ListingItem
import com.example.search_screen.SearchScreenDefaults
import java.time.LocalDate

@Composable
fun ListingRow(
    ad: ListingItem,
    onClick: () -> Unit
) {
   Column(
       Modifier
           .clickable(onClick = onClick)
           .padding(
               horizontal = SearchScreenDefaults.RowHPad,
               vertical = SearchScreenDefaults.RowVPad
           )
   ) {
       // Plug
       Surface(
           color = MaterialTheme.colorScheme.surfaceVariant,
           modifier = Modifier.size(SearchScreenDefaults.ImageSize)
       ) {}
       //
       Spacer(Modifier.width(width = SearchScreenDefaults.ImageTextSpacer))

       Column {
           Text(
               text = ad.title,
               style = MaterialTheme.typography.titleMedium,
               maxLines = 2,
               overflow = TextOverflow.Ellipsis
           )

           Spacer(Modifier.height(height = SearchScreenDefaults.TitleMetaSpacer))
           Text(text = ad.price, style = MaterialTheme.typography.titleMedium)
           Spacer(Modifier.height(height = SearchScreenDefaults.TitleMetaSmallSpacer))
           Text(
               text = ad.location,
               style = MaterialTheme.typography.bodyMedium,
               maxLines = 2,
               overflow = TextOverflow.Ellipsis)
       }
   }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun ListingRowPreview() {
    MaterialTheme {
        ListingRow(
            ad = ListingItem(
                id = "1",
                title = "Test",
                price = "1000",
                imageUrl = null,
                location = "Test",
                status = com.example.api.models.ListingStatus.ACTIVE,
                date = LocalDate.now()


                ),
            onClick = {}
        )
    }
}