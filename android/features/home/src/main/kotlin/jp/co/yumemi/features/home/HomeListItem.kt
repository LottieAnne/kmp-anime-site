package jp.co.yumemi.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import jp.co.yumemi.core.R
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.primitives.Spacing

@Composable
internal fun HomeListItem(
    title: String,
    seasonName: String,
    imageUrl: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(Spacing.XXXL)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (imageUrl == null) {
            Image(
                painter = painterResource(id = R.drawable.img_no_image),
                contentDescription = null,
                modifier = Modifier.size(Spacing.XXXL)
            )
        } else {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(Spacing.XXXL)
            )
        }
        Spacer(modifier = Modifier.width(Spacing.XS))
        Column(
            modifier = Modifier.padding(vertical = Spacing.XXS)
        ) {
            Text(
                text = title,
                style = SampleTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(Spacing.XXS))
            Text(
                text = seasonName,
                style = SampleTheme.typography.body4
            )
        }
    }
}

@Preview
@Composable
private fun HomeListItemPreview() {
    SampleTheme {
        Surface {
            HomeListItem(
                imageUrl = "http://shirobako-anime.com/images/ogp.jpg",
                title = "Title Japanese",
                seasonName = "Season Name",
                onClick = {},
            )
        }
    }
}
