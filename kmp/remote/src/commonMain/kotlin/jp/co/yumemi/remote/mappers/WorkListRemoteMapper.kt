package jp.co.yumemi.remote.mappers

import jp.co.yumemi.data.models.WorkListModel
import jp.co.yumemi.remote.models.HomeApiModel
import jp.co.yumemi.remote.models.WorkApiModel

internal object HomeRemoteMapper {
    fun toDataModel(apiModel: WorkApiModel) = WorkListModel(
        id = apiModel.id,
        title = apiModel.title,
        seasonName = apiModel.seasonName,
        imageUrl = apiModel.image.imageUrl,
    )

    fun toDataModel(apiModel: HomeApiModel): List<WorkListModel> = apiModel.workList.map(::toDataModel)
}
