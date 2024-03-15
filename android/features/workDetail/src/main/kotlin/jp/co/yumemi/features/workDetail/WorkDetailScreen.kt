package jp.co.yumemi.features.workDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.yumemi.core.R
import jp.co.yumemi.core.components.CommonTopAppBar
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.utils.screenPadding
import jp.co.yumemi.domain.entities.WorkDetailEntity
import jp.co.yumemi.domain.entities.WorkEpisodeEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeListDetailScreen(
    workDetail: WorkDetailEntity,
    workEpisode: List<WorkEpisodeEntity>,
) {
    Scaffold(
        topBar = {
            CommonTopAppBar(
                title = stringResource(R.string.work_detail_title),
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
            // TODO: API繋ぎ込み
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                // TODO: 作品イメージ画像挿入
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .background(color = SampleTheme.colors.surface)
                )
                WorkTitleBar(
                    title = workDetail.title,
                    seasonName = workDetail.seasonName
                )
                WorkDetailHeader(title = stringResource(id = R.string.work_detail_title))
                WorkDetailSection(
                    seasonName = workDetail.seasonName,
                    episodes = workDetail.episodes,
                    watchers = workDetail.watchers,
                    reviews = workDetail.reviews,
                )
                WorkDetailHeader(title = stringResource(id = R.string.work_detail_episode))
                workEpisode.forEach { episode ->
                    WorkDetailEpisodeItem(
                        episodeNumber = episode.episodeNumber,
                        episodeTitle = episode.episodeTitle
                    )
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
            workDetail = WorkDetailEntity(
                title = "Title Japanese",
                seasonName = "2014年秋",
                episodes = 24,
                watchers = 125,
                reviews = 125,
            ),
            workEpisode = listOf(
                WorkEpisodeEntity(
                    episodeNumber = 1,
                    episodeTitle = "Title Episode Japanese"
                ),
                WorkEpisodeEntity(
                    episodeNumber = 2,
                    episodeTitle = "Title Episode Japanese"
                ),
                WorkEpisodeEntity(
                    episodeNumber = 3,
                    episodeTitle = "Title Episode Japanese"
                ),
                WorkEpisodeEntity(
                    episodeNumber = 4,
                    episodeTitle = "Title Episode Japanese"
                ),
                WorkEpisodeEntity(
                    episodeNumber = 5,
                    episodeTitle = "Title Episode Japanese"
                ),
                WorkEpisodeEntity(
                    episodeNumber = 6,
                    episodeTitle = "Title Episode Japanese"
                ),
            )
        )
    }
}
