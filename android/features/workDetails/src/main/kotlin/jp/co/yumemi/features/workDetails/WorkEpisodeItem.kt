package jp.co.yumemi.features.workDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.primitives.Spacing


@Composable
internal fun WorkEpisodeItem(
    episodeNumber: String,
    episodeTitle: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = SampleTheme.colors.background)
            .padding(vertical = Spacing.XS, horizontal = Spacing.S),
    ) {
        Text(
            text = episodeNumber,
            color = SampleTheme.colors.onBackground,
            style = SampleTheme.typography.body2
        )
        Spacer(modifier = Modifier.width(Spacing.S))
        Text(
            text = episodeTitle,
            color = SampleTheme.colors.onBackground,
            style = SampleTheme.typography.body3
        )
    }
}

@Preview
@Composable
private fun WorkEpisodePreview() {
    SampleTheme {
        WorkEpisodeItem(episodeNumber = "第1話", episodeTitle = "Title Japanese")
    }
}
