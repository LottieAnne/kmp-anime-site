package jp.co.yumemi.features.workDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.primitives.Spacing


@Composable
internal fun WorkInfoSection(
    seasonName: String,
    episodes: Int,
    watchers: Int,
    reviews: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = SampleTheme.colors.background)
            .padding(vertical = Spacing.XS)
    ) {
        WorkDetailsItem(content = "リリース時期", description = seasonName)
        WorkDetailsItem(content = "エピソード数" , description = episodes.toString() )
        WorkDetailsItem(content ="見た人の数" , description = watchers.toString())
        WorkDetailsItem(content ="レビュー数" , description = reviews.toString())
    }
}

@Preview
@Composable
private fun WorkInfoSectionPreview() {
    SampleTheme {
        WorkInfoSection(
            seasonName = "2014年秋",
            episodes = 24,
            watchers = 1254,
            reviews = 125
        )
    }
}
