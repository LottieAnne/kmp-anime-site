package jp.co.yumemi.features.workDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.primitives.Spacing


@Composable
internal fun WorkDetailsHeader(
    title: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = SampleTheme.colors.surface)
            .padding(vertical = Spacing.XS, horizontal = Spacing.S)
    ) {
        Text(
            text = title,
            color = SampleTheme.colors.onBackground,
            style = SampleTheme.typography.body1
        )
    }
}

@Preview
@Composable
private fun WorkDetailsHeaderPreview() {
    SampleTheme {
        WorkDetailsHeader(
            title = "詳細"
        )
    }
}
