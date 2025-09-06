package com.example.my_ads.list.card

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.api.models.ListingItem
import com.example.api.models.ListingStatus
import java.time.LocalDate

@Composable
fun ListingCard(
    ad: ListingItem,
    onOpen: () -> Unit,
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable{ onOpen() }
        .padding(
            all = 16.dp
        )
    ) {
        CardImage(ad.imageUrl)
        Spacer(Modifier.width(12.dp))
        Column {
            Text(
                text = ad.title,
                fontWeight = FontWeight.SemiBold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(Modifier.height(8.dp))
            Text(
                text = ad.price,
            )
            Spacer(Modifier.height(6.dp))

            Text(
                text = ad.location,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            StatusChip(ad.status)
            Text (
                text = ad.date.toString(),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun ListingCardPreview(){
    val ad = ListingItem(
        id = "1",
        title = "Телефон Телефон Телефон Телефон Телефон Телефон Телефон Телефон Телефон Телефон Телефон Телефон Телефон ",
        price = "115000",
        imageUrl = null,
        location = "Москва, asjbdalfskdfhsdfbsdfsfsbjdfsdfdsfdsfsdfdsfsd",
        status = ListingStatus.ACTIVE,
        date = LocalDate.now(),
    )
    MaterialTheme{
        ListingCard(ad, {})

    }
}