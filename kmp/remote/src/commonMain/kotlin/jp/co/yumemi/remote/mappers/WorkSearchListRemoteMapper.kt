package jp.co.yumemi.remote.mappers

import jp.co.yumemi.data.models.WorkListModel
import jp.co.yumemi.remote.models.WorkApiModel
import jp.co.yumemi.remote.models.WorkListResponseApiModel

internal object WorkSearchListRemoteMapper {
    fun toDataModel(apiModel: WorkApiModel) = WorkListModel(
        id = apiModel.id,
        title = apiModel.title,
        seasonName = apiModel.seasonName,
        imageUrl = apiModel.image.imageUrl,
        episodes = apiModel.episodes,
        watchers = apiModel.watchers,
        reviews = apiModel.reviews,
    )

    fun toDataModel(apiModel: WorkListResponseApiModel): List<WorkListModel> =
        apiModel.workList.map(::toDataModel)
}
