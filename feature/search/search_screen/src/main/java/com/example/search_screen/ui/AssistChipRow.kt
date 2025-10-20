package com.example.search_screen.ui


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.search_screen.utils.SearchScreenDefaults
import com.example.search_screen.R as SearchR


@Composable
fun AssistChipRow(
    onQuery: (String) -> Unit,
    suggestions: List<String>
) {
    Row(Modifier.padding(
        horizontal = SearchScreenDefaults.AssistRowHPad,
        vertical = SearchScreenDefaults.AssistRowVPad)
    ) {
        suggestions.forEachIndexed { index, suggestion ->
            AssistChip(
                onClick = { onQuery(suggestion) },
                label = { Text(suggestion) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(
                            id = SearchR.string.search_placeholder
                        )
                    )},
                modifier = if (index == 0) Modifier else Modifier
                    .padding(start = SearchScreenDefaults.AssistChipStartGap)
            )
        }
    }
}


@Preview
@Composable
fun AssistChipRowPreview() {
    MaterialTheme{
        AssistChipRow(
            suggestions = listOf("Test1", "Test2", "Test3"),
            onQuery = {}
        )
    }
}