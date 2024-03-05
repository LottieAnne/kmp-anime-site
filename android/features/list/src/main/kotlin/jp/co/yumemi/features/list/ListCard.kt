package jp.co.yumemi.features.list

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import jp.co.yumemi.core.primitives.Spacing
import jp.co.yumemi.core.R

@Composable
internal fun ListCard(
    @DrawableRes
    image: Int,
    title: String,
    seasonName: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(Spacing.XXXL),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.size(Spacing.XXXL)
        )
        Spacer(modifier = Modifier.width(Spacing.XS))
        Column(
            modifier = Modifier.padding(vertical = Spacing.XXS)
        ) {
            Text(
                text = title,
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium)
            )
            Spacer(modifier = Modifier.height(Spacing.XXS))
            Text(
                text = seasonName,
                style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Normal)
            )
        }
    }
}

@Preview
@Composable
private fun ListCardPreview() {
    Surface {
        ListCard(
            image = R.drawable.img_no_image,
            title = "Title Japanese", seasonName = "Season Name"
        )
    }
}