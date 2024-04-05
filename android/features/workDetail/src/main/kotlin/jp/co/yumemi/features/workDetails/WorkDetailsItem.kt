package jp.co.yumemi.features.workDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
internal fun WorkDetailsItem(
    content: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = SampleTheme.colors.onPrimary)
            .padding(vertical = Spacing.XS, horizontal = Spacing.S),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = content,
            color = SampleTheme.colors.onBackground,
            style = SampleTheme.typography.body2
        )
        Spacer(modifier = Modifier.width(Spacing.S))
        Text(
            text = description,
            color = SampleTheme.colors.onBackground,
            style = SampleTheme.typography.body3
        )
    }
}

@Preview
@Composable
private fun WorkDetailsItemPreview() {
    SampleTheme {
        WorkDetailsItem(
            content = "リリース時期",
            description = "2014年秋"
        )
    }
}
