package com.example.search_screen.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.search_screen.utils.SearchScreenDefaults


@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(
            horizontal = SearchScreenDefaults.SectionHeaderHPad,
            vertical = SearchScreenDefaults.SectionHeaderVPad
        )
    )
}


@Preview
@Composable
fun SectionHeaderPreview() {
    MaterialTheme{
        SectionHeader("Test")
    }
}