package jp.co.yumemi.data.mappers

import jp.co.yumemi.data.models.WorkEpisodeListModel
import jp.co.yumemi.domain.entities.WorkEpisodeEntity

internal object WorkEpisodeListDataMapper {
    fun toEntity(model: WorkEpisodeListModel) = WorkEpisodeEntity(
        episodeNumber = model.episodeNumber,
        episodeTitle = model.episodeTitle,
    )
}
