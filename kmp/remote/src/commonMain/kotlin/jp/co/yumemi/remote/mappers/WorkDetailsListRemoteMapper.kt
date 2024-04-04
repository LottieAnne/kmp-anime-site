package jp.co.yumemi.remote.mappers

import jp.co.yumemi.data.models.WorkDetailsListModel
import jp.co.yumemi.remote.models.WorkDetailsApiModel
import jp.co.yumemi.remote.models.WorkDetailsListResponseApiModel

internal object WorkDetailsListRemoteMapper {
    fun toDataModel(apiModel: WorkDetailsApiModel) = WorkDetailsListModel(
        title = apiModel.title,
        seasonName = apiModel.seasonName,
        episodes = apiModel.episodes,
        watchers = apiModel.watchers,
        reviews = apiModel.reviews,
    )

    fun toDataModel(apiModel: WorkDetailsListResponseApiModel): List<WorkDetailsListModel> =
        apiModel.workDetailsList.map(::toDataModel)
}
