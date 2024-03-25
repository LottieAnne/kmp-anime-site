package jp.co.yumemi.data.mappers

import jp.co.yumemi.data.models.HomeModel
import jp.co.yumemi.domain.entities.HomeEntity

internal object HomeDataMapper {
    fun toEntity(model: HomeModel) = HomeEntity(
        id = model.id,
        title = model.title,
        seasonName = model.seasonName,
        imageUrl = model.imageUrl
    )
}
