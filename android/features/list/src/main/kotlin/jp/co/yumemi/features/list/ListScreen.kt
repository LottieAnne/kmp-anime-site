package jp.co.yumemi.features.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.core.utils.render
import jp.co.yumemi.domain.entities.ListCardEntity
import jp.co.yumemi.list.ListState

@Composable
fun ListScreen(
    state: ListState,
    onClickListCard: () -> Unit,
) {
    state.render<ListState.Loading> {
        // TODO: LoadingIndicatorを実装する
    }

    state.render<ListState.Error> {
        // TODO: Errorを実装
    }

    state.render<ListState.Stable> {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            list.forEach { item ->
                ListCard(
                    title = item.title,
                    seasonName = item.seasonName,
                    onClick = onClickListCard,
                )
            }
        }
    }

}

@Preview
@Composable
private fun ListScreenPreview() {
    Surface {
        ListScreen(
            state = ListState.Stable.Initial(
                list = listOf(
                    ListCardEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    ListCardEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    ListCardEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    ListCardEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    ListCardEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    ListCardEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    ListCardEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    ListCardEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    ListCardEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    ListCardEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    ListCardEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    ListCardEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    ListCardEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    ListCardEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    ListCardEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    ListCardEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    ListCardEntity(
                        image = null,
                        title = "Title Japanese",
                        seasonName = "Season Name"
                    ),
                    ListCardEntity(
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
