package com.example.search_screen.ui



import androidx.compose.foundation.clickable
import com.example.search_screen.R as SearchR
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.search_screen.SearchScreenDefaults

@Composable
fun SuggestionsAndHistory(
    history: List<String> = emptyList(),
    onPick: (String) -> Unit = {},
    onClearHistory: () -> Unit = {},
){
    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = SearchScreenDefaults.AssistRowVPad)
    ) {
        if (history.isNotEmpty()) {
            Text(
                text = stringResource(id = SearchR.string.search_history_title),
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(
                    horizontal = SearchScreenDefaults.SuggestionLabelHPad,
                    vertical = SearchScreenDefaults.SuggestionLabelVPad
                )
            )
            history.forEach { historyItem ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onPick(historyItem)}
                        .padding(
                            horizontal = SearchScreenDefaults.SuggestionRowHPad,
                            vertical = SearchScreenDefaults.SuggestionRowVPad
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                    Spacer(Modifier.width(width = SearchScreenDefaults.ImageTextSpacer))
                    Text(text = historyItem, style = MaterialTheme.typography.bodyLarge)
                }
            }
            TextButton(
                onClick = onClearHistory,
                modifier = Modifier.padding(horizontal = SearchScreenDefaults.AssistRowHPad)
            ) {
                Text(text = stringResource(id = SearchR.string.search_clear_history))
            }
        } else {
            Text(
                text = stringResource(id = SearchR.string.search_no_suggestions),
                modifier = Modifier.padding(SearchScreenDefaults.HintPadAll)
            )
        }
    }
}


@Preview
@Composable
fun SuggestionsAndHistoryWithHistoryPreview() {
    MaterialTheme {
        SuggestionsAndHistory(
            history = listOf("Test", "Test2"),
            onPick = {},
            onClearHistory = {}
        )
    }
}

@Preview
@Composable
fun SuggestionsAndHistoryWithoutHistoryPreview() {
    MaterialTheme {
        SuggestionsAndHistory(
            history = emptyList(),
            onPick = {},
            onClearHistory = {}
        )
    }
}