package jp.co.yumemi.features.workDetails

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.yumemi.core.R
import jp.co.yumemi.core.components.CommonTopAppBar
import jp.co.yumemi.core.foundation.Contract
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.utils.render
import jp.co.yumemi.core.utils.screenPadding
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.domain.entities.WorkEpisodeEntity
import jp.co.yumemi.workDetails.WorkDetailsEvent
import jp.co.yumemi.workDetails.WorkDetailsIntent
import jp.co.yumemi.workDetails.WorkDetailsState

@Composable
fun WorkDetailsScreenRoot(
    contract: Contract<WorkDetailsIntent, WorkDetailsState, WorkDetailsEvent>,
) {
    val (state, dispatch) = contract

    LaunchedEffect(Unit) {
        dispatch(WorkDetailsIntent.OnStart)
    }

    WorkDetailsScreen(
        state = state,
        dispatch = dispatch,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WorkDetailsScreen(
    state: WorkDetailsState,
    dispatch: (WorkDetailsIntent) -> Unit,
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
            state.render<WorkDetailsState.Loading> {
                // TODO: 実装
            }
            state.render<WorkDetailsState.Error> {
                // TODO: 実装
            }
            state.render<WorkDetailsState.Stable> {
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
                        title = work.title,
                        seasonName = work.seasonName
                    )
                    WorkDetailsHeader(title = stringResource(id = R.string.work_detail_title))
                    WorkInfoSection(
                        seasonName = work.seasonName,
                        episodes = work.episodes,
                        watchers = work.watchers,
                        reviews = work.reviews,
                    )
                    WorkDetailsHeader(title = stringResource(id = R.string.work_detail_episode))
                    workEpisodeList.forEach { episode ->
                        WorkEpisodeItem(
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
private fun WorkDetailsScreenPreview() {
    SampleTheme {
        WorkDetailsScreen(
            state = WorkDetailsState.Stable(
                work = WorkEntity(
                    id = 1,
                    title = "Title Japanese",
                    seasonName = "2014年秋",
                    imageUrl = null,
                    episodes = 24,
                    watchers = 125,
                    reviews = 125,
                ),
                workEpisodeList = listOf(
                    WorkEpisodeEntity(
                        episodeNumber = "第1話",
                        episodeTitle = "Title Episode Japanese"
                    ),
                    WorkEpisodeEntity(
                        episodeNumber = "第2話",
                        episodeTitle = "Title Episode Japanese"
                    ),
                    WorkEpisodeEntity(
                        episodeNumber = "第3話",
                        episodeTitle = "Title Episode Japanese"
                    ),
                    WorkEpisodeEntity(
                        episodeNumber = "第4話",
                        episodeTitle = "Title Episode Japanese"
                    ),
                    WorkEpisodeEntity(
                        episodeNumber = "第5話",
                        episodeTitle = "Title Episode Japanese"
                    ),
                    WorkEpisodeEntity(
                        episodeNumber = "第6話",
                        episodeTitle = "Title Episode Japanese"
                    ),
                )
            ),
            dispatch = {},
        )
    }
}
