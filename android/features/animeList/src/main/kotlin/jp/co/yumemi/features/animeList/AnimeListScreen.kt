package jp.co.yumemi.features.animeList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.core.R
import jp.co.yumemi.core.components.CommonTopAppBar
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.utils.render
import jp.co.yumemi.core.utils.screenPadding
import jp.co.yumemi.domain.entities.AnimeListItemEntity
import jp.co.yumemi.animeList.AnimeListState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeListScreen(
    state: AnimeListState,
    onClickListCard: () -> Unit,
) {
    Scaffold(
        topBar = {
            CommonTopAppBar(title = stringResource(R.string.anime_list_title))
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
            state.render<AnimeListState.Loading> {
                // TODO: LoadingIndicatorを実装する
            }

            state.render<AnimeListState.Error> {
                // TODO: Errorを実装
            }

            state.render<AnimeListState.Stable> {
                // TODO: API繋ぎ込み
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    animeList.forEach { item ->
                        AnimeListItem(
                            title = item.title,
                            seasonName = item.seasonName,
                            onClick = onClickListCard,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun AnimeListScreenPreview() {
    SampleTheme {
        AnimeListScreen(
            state = AnimeListState.Stable.Initial(
                animeList = listOf(
                    AnimeListItemEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    AnimeListItemEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    AnimeListItemEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    AnimeListItemEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    AnimeListItemEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    AnimeListItemEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    AnimeListItemEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    AnimeListItemEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    AnimeListItemEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    AnimeListItemEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    AnimeListItemEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    AnimeListItemEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    AnimeListItemEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    AnimeListItemEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    AnimeListItemEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    AnimeListItemEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    AnimeListItemEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    AnimeListItemEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                )
            ),
            onClickListCard = {},
        )
    }
}
