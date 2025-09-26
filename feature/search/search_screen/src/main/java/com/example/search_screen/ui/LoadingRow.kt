package com.example.search_screen.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.search_screen.SearchScreenDefaults




@Composable
fun LoadingRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = SearchScreenDefaults.RowHPad,
                vertical = SearchScreenDefaults.RowVPad
            )
            .height(SearchScreenDefaults.RowHeight),
        verticalAlignment = Alignment.CenterVertically
    ){
        ImageSkeleton()
        Spacer(Modifier.width(SearchScreenDefaults.ImageTextSpacer))
        Column(modifier = Modifier.weight(1f)) {
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
        color = MaterialTheme.colorScheme.surfaceVariant,
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
    SkeletonBox(modifier = modifier.size(size))
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

