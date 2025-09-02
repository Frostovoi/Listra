package com.example.my_ads.list.card

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.my_ads.models.ListingStatus

@Composable
fun StatusChip(
    status: ListingStatus
) {
    val (label, color) = when (status) {
        ListingStatus.ACTIVE -> "Active" to MaterialTheme.colorScheme.primary
        ListingStatus.ARCHIVED -> "Sold" to MaterialTheme.colorScheme.secondary
        ListingStatus.DRAFT -> "Pending" to MaterialTheme.colorScheme.tertiary
    }
    AssistChip(
        onClick = {},
        label = { Text(label) },
        border = AssistChipDefaults.assistChipBorder(
            enabled = true,
            borderColor = color
        )
    )
}

@Preview
@Composable
fun StatusChipPreview() {
    MaterialTheme {
        Column{
            StatusChip(ListingStatus.ACTIVE)
            StatusChip(ListingStatus.ARCHIVED)
            StatusChip(ListingStatus.DRAFT)
        }
    }
}
