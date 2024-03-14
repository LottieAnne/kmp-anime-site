package jp.co.yumemi.features.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.utils.render
import jp.co.yumemi.core.utils.screenPadding
import jp.co.yumemi.splash.SplashState
import jp.co.yumemi.core.R

@Composable
fun SplashScreen(
    state: SplashState,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.screenPadding(),
    ) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_splash_search),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )

            state.render<SplashState.Error> {
                // TOOD: Error画面実装
            }
        }
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SampleTheme {
        SplashScreen(
            state = SplashState.Initial,
        )
    }
}
