package jp.co.yumemi.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.core.R
import jp.co.yumemi.core.components.CommonTopAppBar
import jp.co.yumemi.core.foundation.Contract
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.utils.render
import jp.co.yumemi.core.utils.screenPadding
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.home.HomeEvent
import jp.co.yumemi.home.HomeIntent
import jp.co.yumemi.home.HomeState

@Composable
fun HomeScreenRoot(
    contract: Contract<HomeIntent, HomeState, HomeEvent>,
) {
    val (state, dispatch) = contract

    LaunchedEffect(Unit) {
        dispatch(HomeIntent.OnStart)
    }

    HomeScreen(
        state = state,
        dispatch = dispatch,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen(
    state: HomeState,
    dispatch: (HomeIntent) -> Unit,
) {
    Scaffold(
        topBar = {
            CommonTopAppBar(title = stringResource(R.string.home_title))
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
            state.render<HomeState.Loading> {
                // TODO: Loading画面の追加
            }

            state.render<HomeState.Error> {
                // TODO: Error文言の追加
            }

            state.render<HomeState.Stable> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    workList.forEach { item ->
                        HomeListItem(
                            title = item.title,
                            seasonName = item.seasonName,
                            imageUrl = item.imageUrl,
                            onClick = { dispatch(HomeIntent.ClickListItem(item)) },
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    SampleTheme {
        HomeScreen(
            state = HomeState.Stable(
                workList = listOf(
                    WorkEntity(
                        title = "Title Japanese",
                        seasonName = "Season Name",
                        imageUrl = null,
                    ),
                    WorkEntity(
                        title = "Title Japanese",
                        seasonName = "Season Name",
                        imageUrl = null,
                    ),
                    WorkEntity(
                        title = "Title Japanese",
                        seasonName = "Season Name",
                        imageUrl = null,
                    ),
                    WorkEntity(
                        title = "Title Japanese",
                        seasonName = "Season Name",
                        imageUrl = null,
                    ),
                    WorkEntity(
                        title = "Title Japanese",
                        seasonName = "Season Name",
                        imageUrl = null,
                    ),
                    WorkEntity(
                        title = "Title Japanese",
                        seasonName = "Season Name",
                        imageUrl = null,
                    ),
                    WorkEntity(
                        title = "Title Japanese",
                        seasonName = "Season Name",
                        imageUrl = null,
                    ),
                ),
            ),
            dispatch = {},
        )
    }
}
