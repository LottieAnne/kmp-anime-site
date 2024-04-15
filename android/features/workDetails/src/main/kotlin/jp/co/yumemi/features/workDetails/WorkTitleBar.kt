package jp.co.yumemi.features.workDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.core.R
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.primitives.Spacing

@Composable
internal fun WorkTitleBar(
    title: String,
    seasonName: String,
    modifier: Modifier = Modifier,
) {
    var isFavorite: Boolean by remember { mutableStateOf(false) }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = SampleTheme.colors.onBackground.copy(0.6f))
            .padding(horizontal = Spacing.S),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(
            modifier = Modifier.padding(vertical = Spacing.XS)
        ) {
            Text(
                text = title,
                color = SampleTheme.colors.onPrimary,
                style = SampleTheme.typography.headline2
            )
            Spacer(modifier = Modifier.height(Spacing.XXS))
            Text(
                text = seasonName,
                color = SampleTheme.colors.onPrimary,
                style = SampleTheme.typography.body2
            )
        }
        Spacer(modifier = Modifier.width(Spacing.XXS))
        Icon(
            painter =
            if (isFavorite) painterResource(id = R.drawable.icon_favorite_filled)
            else painterResource(id = R.drawable.icon_favorite_empty),
            contentDescription = null,
            tint = SampleTheme.colors.onPrimary,
            modifier = Modifier.clickable { isFavorite = !isFavorite }
        )
    }
}

@Preview
@Composable
private fun WorkTitleBarPreview() {
    SampleTheme {
        Surface {
            WorkTitleBar(
                title = "Title Japanese",
                seasonName = "2016年春"
            )
        }
    }
}
