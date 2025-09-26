package com.example.search_screen

import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Stable
internal object SearchScreenDefaults {
    const val SKELETON_COUNT: Int = 6
    const val TITLE_WIDTH_FRACTION: Float = 0.8f
    const val META_WIDTH_FRACTION: Float = 0.4f

    const val CT_HEADER  = "header"
    const val CT_LISTING = "listing"

    val ContentBottomPadding: Dp = 24.dp
    val SectionHeaderHPad: Dp = 16.dp
    val SectionHeaderVPad: Dp = 12.dp
    val RowHPad: Dp = 16.dp
    val RowVPad: Dp = 12.dp
    val RowHeight: Dp = 72.dp
    val ImageSize: Dp = 144.dp
    val ImageTextSpacer: Dp = 12.dp
    val TitleMetaSpacer: Dp = 8.dp
    val TitleMetaSmallSpacer: Dp = 4.dp
    val TitleSkeletonHeight: Dp = 18.dp
    val MetaSkeletonHeight: Dp = 14.dp
    val HintPadAll: Dp = 16.dp
    val SuggestionLabelHPad: Dp = 16.dp
    val SuggestionLabelVPad: Dp = 6.dp
    val SuggestionRowHPad: Dp = 16.dp
    val SuggestionRowVPad: Dp = 10.dp
    val AssistRowHPad: Dp = 12.dp
    val AssistRowVPad: Dp = 8.dp
    val AssistChipStartGap: Dp = 8.dp
}