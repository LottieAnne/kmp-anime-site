package jp.co.yumemi.features.tutorial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.yumemi.core.R
import jp.co.yumemi.core.components.Button
import jp.co.yumemi.core.components.CommonTopAppBar
import jp.co.yumemi.core.foundation.Contract
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.primitives.Spacing
import jp.co.yumemi.core.utils.handleEvents
import jp.co.yumemi.core.utils.render
import jp.co.yumemi.core.utils.screenPadding
import jp.co.yumemi.tutorial.TutorialEvent
import jp.co.yumemi.tutorial.TutorialIntent
import jp.co.yumemi.tutorial.TutorialState

@Composable
fun TutorialScreenRoot(
    contract: Contract<TutorialIntent, TutorialState, TutorialEvent>,
    navigator: TutorialNavigator,
) {
    val (state, dispatch) = contract

    contract.handleEvents { event ->
        when (event) {
            is TutorialEvent.NavigateList -> navigator.workList()
        }
    }

    TutorialScreen(
        state = state,
        dispatch = dispatch
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TutorialScreen(
    state: TutorialState,
    dispatch: (TutorialIntent) -> Unit,
) {
    Scaffold(
        topBar = {
            CommonTopAppBar(title = stringResource(R.string.tutorial_title))
        },
        modifier = Modifier.screenPadding(),
    ) { contentPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(color = SampleTheme.colors.background)
                .padding(paddingValues = contentPadding),
        ) {
            state.render<TutorialState.Stable> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(vertical = Spacing.XXXL)
                ) {
                    Box(
                        modifier = Modifier
                            .size(200.dp)
                            .background(color = Color.LightGray)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = stringResource(id = R.string.tutorial_body),
                        style = SampleTheme.typography.headline1
                    )
                    Text(
                        text = stringResource(id = R.string.tutorial_body),
                        style = SampleTheme.typography.headline1
                    )
                    Text(
                        text = stringResource(id = R.string.tutorial_body),
                        style = SampleTheme.typography.headline1
                    )
                    Spacer(modifier = Modifier.weight(3f))
                    Button(
                        text = stringResource(R.string.tutorial_start),
                        onClick = { dispatch(TutorialIntent.ClickStart) })
                }
            }
        }
    }
}

@Preview
@Composable
private fun TutorialScreenPreview() {
    SampleTheme {
        TutorialScreen(
            state = TutorialState.Stable,
            dispatch = {},
        )
    }
}
