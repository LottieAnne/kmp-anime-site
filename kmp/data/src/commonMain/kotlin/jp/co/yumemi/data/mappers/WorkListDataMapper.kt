package jp.co.yumemi.data.mappers

import jp.co.yumemi.data.models.WorkListModel
import jp.co.yumemi.domain.entities.WorkEntity

internal object WorkListDataMapper {
    fun toEntity(model: WorkListModel) = WorkEntity(
        id = model.id,
        title = model.title,
        seasonName = model.seasonName,
        imageUrl = model.imageUrl,
        episodes = model.episodes,
        watchers = model.watchers,
        reviews = model.reviews,
    )
}
