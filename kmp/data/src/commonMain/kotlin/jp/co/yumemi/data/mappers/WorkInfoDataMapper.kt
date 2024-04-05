package jp.co.yumemi.data.mappers

import jp.co.yumemi.data.models.WorkInfoModel
import jp.co.yumemi.data.models.WorkListModel
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.domain.entities.WorkInfoEntity

internal object WorkInfoDataMapper {
    fun toEntity(model: WorkInfoModel) = WorkInfoEntity(
        title = model.title,
        seasonName = model.seasonName,
        episodes = model.episodes,
        watchers = model.watchers,
        reviews = model.reviews,
    )
}
