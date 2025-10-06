package com.example.search_screen.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.api.models.ListingItem
import com.example.search_screen.utils.SearchScreenDefaults
import java.time.LocalDate
import com.example.search_screen.R as SearchR

@Composable
fun ListingRow(
    ad: ListingItem,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick
    ) {
        Column(
            Modifier
                .clickable(onClick = onClick)
                .padding(
                    horizontal = SearchScreenDefaults.RowHPad,
                    vertical = SearchScreenDefaults.RowVPad
                )
        ) {
            AsyncImage(
                model = ad.imageUrl,
                placeholder = painterResource(SearchR.drawable.placeholder),
                error = painterResource(SearchR.drawable.placeholder_error),
                contentDescription = ad.title,
                modifier = Modifier
                    .size(SearchScreenDefaults.ImageSize)
            )

            Spacer(Modifier.width(width = SearchScreenDefaults.ImageTextSpacer))

            Text(
                text = ad.title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.width(SearchScreenDefaults.TitleUnderImageWidth),
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
                overflow = TextOverflow.Ellipsis
            )
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
                title = "TestTestTestTestTestTestTestTestTest",
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