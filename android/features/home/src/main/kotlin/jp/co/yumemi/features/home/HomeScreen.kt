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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.core.R
import jp.co.yumemi.core.components.CommonTopAppBar
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.utils.screenPadding
import jp.co.yumemi.domain.entities.HomeEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeList: List<HomeEntity>,
    onClickListCard: () -> Unit,
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                homeList.forEach { item ->
                    HomeListItem(
                        title = item.title,
                        seasonName = item.seasonName,
                        imageUrl = item.imageUrl,
                        onClick = onClickListCard,
                    )
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
            homeList = listOf(
                HomeEntity(
                    title = "Title Japanese",
                    seasonName = "Season Name",
                    imageUrl = null,
                ),
                HomeEntity(
                    title = "Title Japanese",
                    seasonName = "Season Name",
                    imageUrl = null,
                ),
                HomeEntity(
                    title = "Title Japanese",
                    seasonName = "Season Name",
                    imageUrl = null,
                ),
                HomeEntity(
                    title = "Title Japanese",
                    seasonName = "Season Name",
                    imageUrl = null,
                ),
                HomeEntity(
                    title = "Title Japanese",
                    seasonName = "Season Name",
                    imageUrl = null,
                ),
                HomeEntity(
                    title = "Title Japanese",
                    seasonName = "Season Name",
                    imageUrl = null,
                ),
                HomeEntity(
                    title = "Title Japanese",
                    seasonName = "Season Name",
                    imageUrl = null,
                ),
            ),
            onClickListCard = {},
        )
    }
}
