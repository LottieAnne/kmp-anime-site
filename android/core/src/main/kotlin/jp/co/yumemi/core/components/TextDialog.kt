package jp.co.yumemi.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.primitives.Spacing

@Composable
fun NewDialog(
    title: String,
    message: String,
    positiveText: String? = null,
    negativeText: String? = null,
    positiveOnClick: (() -> Unit)? = null,
    negativeOnClick: (() -> Unit)? = null,
    onDismissRequest: () -> Unit = {},
    isEnablePositiveButton: Boolean = true,
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Column(
            modifier = Modifier
                .background(SampleTheme.colors.primaryVariant, shape = RoundedCornerShape(8.dp))
        ) {
            Text(
                text = title,
                style = SampleTheme.typography.headline1,
                color = SampleTheme.colors.onPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = Spacing.S)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = SampleTheme.colors.background)
                    .padding(vertical = Spacing.S, horizontal = Spacing.XS),
            ) {
                Text(
                    text = message,
                    color = SampleTheme.colors.primary,
                    style = SampleTheme.typography.subtitle,
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .weight(weight = 1f, fill = false),
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = SampleTheme.colors.background)
                    .padding(horizontal = Spacing.XS),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(space = Spacing.XS),
            ) {
                if (negativeText != null && negativeOnClick != null) {
                    Button(
                        text = negativeText,
                        onClick = negativeOnClick,
                        size = ButtonSize.S,
                        modifier = Modifier.weight(weight = 1f),
                    )
                }
                if (positiveText != null && positiveOnClick != null) {
                    if (isEnablePositiveButton) {
                        Button(
                            text = positiveText,
                            onClick = positiveOnClick,
                            size = ButtonSize.S,
                            modifier = Modifier.weight(weight = 1f),
                        )
                    } else {
                        Button(
                            text = positiveText,
                            onClick = positiveOnClick,
                            enabled = false,
                            size = ButtonSize.S,
                            modifier = Modifier.weight(weight = 1f),
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun TextDialogPreview() {
    SampleTheme {
        NewDialog(
            title = "Dialog Title",
            message = "Dialog Message",
            positiveText = "Positive",
            negativeText = "Negative",
            positiveOnClick = {},
            negativeOnClick = {},
        )
    }
}
