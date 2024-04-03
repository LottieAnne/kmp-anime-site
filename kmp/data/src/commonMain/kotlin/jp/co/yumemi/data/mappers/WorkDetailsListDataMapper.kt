package jp.co.yumemi.data.mappers

import jp.co.yumemi.data.models.WorkDetailsListModel
import jp.co.yumemi.domain.entities.WorkDetailsEntity

internal object WorkDetailsListDataMapper {
    fun toEntity(model: WorkDetailsListModel) = WorkDetailsEntity(
        title = model.title,
        seasonName = model.seasonName,
        episodes = model.episodes,
        watchers = model.watchers,
        reviews = model.reviews
    )
}
