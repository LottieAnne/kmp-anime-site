package jp.co.yumemi.features.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.yumemi.core.R
import jp.co.yumemi.core.foundation.Contract
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.utils.handleEvents
import jp.co.yumemi.core.utils.render
import jp.co.yumemi.core.utils.screenPadding
import jp.co.yumemi.splash.SplashEvent
import jp.co.yumemi.splash.SplashIntent
import jp.co.yumemi.splash.SplashState

@Composable
fun SplashScreenRoot(
    contract: Contract<SplashIntent, SplashState, SplashEvent>,
    navigator: SplashNavigator,
) {
    val (state, dispatch) = contract

    LaunchedEffect(Unit) {
        dispatch(SplashIntent.OnStart)
    }

    contract.handleEvents { event ->
        when (event) {
            is SplashEvent.NavigateTutorial -> navigator.tutorial()
            is SplashEvent.NavigateWorkList -> navigator.workList()
        }
    }

    SplashScreen(state = state, dispatch = dispatch)
}


@Composable
private fun SplashScreen(
    state: SplashState,
    dispatch: (SplashIntent) -> Unit,
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
            state.render<SplashState.Stable> {
                Image(
                    painter = painterResource(id = R.drawable.img_splash_search),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SampleTheme {
        SplashScreen(
            state = SplashState.Stable,
            dispatch = {},
        )
    }
}
