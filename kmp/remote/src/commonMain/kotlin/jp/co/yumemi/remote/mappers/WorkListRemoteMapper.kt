package jp.co.yumemi.remote.mappers

import jp.co.yumemi.data.models.WorkListModel
import jp.co.yumemi.remote.models.WorkApiModel
import jp.co.yumemi.remote.models.WorkListResponseApiModel

internal object WorkListRemoteMapper {
    fun toDataModel(apiModel: WorkApiModel) = WorkListModel(
        title = apiModel.title,
        seasonName = apiModel.seasonName,
        imageUrl = apiModel.image.imageUrl,
    )

    fun toDataModel(apiModel: WorkListResponseApiModel): List<WorkListModel> =
        apiModel.workList.map(::toDataModel)
}
