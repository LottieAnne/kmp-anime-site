package jp.co.yumemi.data.mappers

import jp.co.yumemi.data.models.WorkListModel
import jp.co.yumemi.domain.entities.WorkEntity

internal object WorkListDataMapper {
    fun toEntity(model: WorkListModel) = WorkEntity(
        title = model.title,
        seasonName = model.seasonName,
        imageUrl = model.imageUrl
    )
}
