package com.example.search_screen.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.search_screen.utils.SearchScreenDefaults


@Composable
fun LoadingRow() {
    Card {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = SearchScreenDefaults.RowHPad,
                    vertical = SearchScreenDefaults.RowVPad
                ),

            ) {
            ImageSkeleton()
            Spacer(Modifier.height(SearchScreenDefaults.ImageTextSpacer))
            TitleSkeleton()
            Spacer(Modifier.height(SearchScreenDefaults.TitleMetaSpacer))
            MetaSkeleton()
        }
    }
}

@Composable
private fun SkeletonBox(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
) {
    Surface(
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = modifier,
        shape = shape,
        tonalElevation = 1.dp
    ) {}
}



@Composable
private fun ImageSkeleton(
    modifier: Modifier = Modifier,
    size: Dp = SearchScreenDefaults.ImageSize
) {
    SkeletonBox(modifier = modifier
        .size(size))
}


@Composable
private fun TitleSkeleton(
    modifier: Modifier = Modifier,
    widthFraction: Float = SearchScreenDefaults.TITLE_WIDTH_FRACTION,
    height: Dp = SearchScreenDefaults.TitleSkeletonHeight
) {
    SkeletonBox(
        modifier = modifier
            .fillMaxWidth(widthFraction)
            .height(height),
    )
}


@Composable
private fun MetaSkeleton(
    modifier: Modifier = Modifier,
    widthFraction: Float = SearchScreenDefaults.META_WIDTH_FRACTION,
    height: Dp = SearchScreenDefaults.MetaSkeletonHeight
) {
    SkeletonBox(
        modifier = modifier
            .fillMaxWidth(widthFraction)
            .height(height)
    )
}

@Preview
@Composable
fun LoadingRowPreview() {
    MaterialTheme{
        LoadingRow()
    }
}

