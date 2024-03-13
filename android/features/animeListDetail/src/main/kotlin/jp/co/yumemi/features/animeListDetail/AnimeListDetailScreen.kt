package jp.co.yumemi.features.animeListDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.yumemi.animeListDetail.AnimeListDetailState
import jp.co.yumemi.core.R
import jp.co.yumemi.core.components.CommonTopAppBar
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.utils.render
import jp.co.yumemi.core.utils.screenPadding
import jp.co.yumemi.domain.entities.AnimeEpisodeEntity
import jp.co.yumemi.domain.entities.AnimeListDetailEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeListDetailScreen(
    state: AnimeListDetailState,
) {
    Scaffold(
        topBar = {
            CommonTopAppBar(
                title = stringResource(R.string.anime_list_detail_title),
                navigationIcon = {
                    // TODO: onClick実装
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
            )
        },
        modifier = Modifier.screenPadding(),
    ) { contentPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = SampleTheme.colors.background)
                .padding(paddingValues = contentPadding),
        ) {
            state.render<AnimeListDetailState.Loading> {
                // TODO: LoadingIndicatorを実装する
            }

            state.render<AnimeListDetailState.Error> {
                // TODO: Errorを実装
            }

            state.render<AnimeListDetailState.Stable> {
                // TODO: API繋ぎ込み
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .background(color = SampleTheme.colors.surface)
                    )
                    AnimeTitleBar(
                        title = animeListDetail.animeTitle,
                        seasonName = animeListDetail.seasonName
                    )
                    AnimeListDetailSubtitle(subtitle = stringResource(id = R.string.anime_list_detail_title))
                    AnimeListDetailSection(
                        seasonName = animeListDetail.seasonName,
                        episodes = animeListDetail.episodes,
                        watchers = animeListDetail.watchers,
                        reviews = animeListDetail.reviews,
                    )
                    AnimeListDetailSubtitle(subtitle = stringResource(id = R.string.anime_list_detail_episode))
                    animeEpisodeDetail.forEach { episode ->
                        AnimeListEpisodeItem(
                            episodeNumber = episode.episodeNumber,
                            episodeTitle = episode.episodeTitle
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun AnimeListDetailScreenPreview() {
    SampleTheme {
        AnimeListDetailScreen(
            state = AnimeListDetailState.Stable.Initial(
                animeListDetail = AnimeListDetailEntity(
                    animeTitle = "Title Japanese",
                    seasonName = "2014年秋",
                    episodes = 24,
                    watchers = 125,
                    reviews = 125,
                ),
                animeEpisodeDetail = listOf(
                    AnimeEpisodeEntity(
                        episodeNumber = 1,
                        episodeTitle = "Title Episode Japanese"
                    ),
                    AnimeEpisodeEntity(
                        episodeNumber = 2,
                        episodeTitle = "Title Episode Japanese"
                    ),
                    AnimeEpisodeEntity(
                        episodeNumber = 3,
                        episodeTitle = "Title Episode Japanese"
                    ),
                    AnimeEpisodeEntity(
                        episodeNumber = 4,
                        episodeTitle = "Title Episode Japanese"
                    ),
                    AnimeEpisodeEntity(
                        episodeNumber = 5,
                        episodeTitle = "Title Episode Japanese"
                    ),
                    AnimeEpisodeEntity(
                        episodeNumber = 6,
                        episodeTitle = "Title Episode Japanese"
                    ),
                )
            ),
        )
    }
}
