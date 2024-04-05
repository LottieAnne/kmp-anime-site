package jp.co.yumemi.remote.mappers

import jp.co.yumemi.data.models.WorkInfoModel
import jp.co.yumemi.data.models.WorkListModel
import jp.co.yumemi.remote.models.WorkApiModel
import jp.co.yumemi.remote.models.WorkInfoApiModel
import jp.co.yumemi.remote.models.WorkInfoResponseApiModel
import jp.co.yumemi.remote.models.WorkListResponseApiModel

internal object WorkInfoRemoteMapper {
    fun toDataModel(apiModel: WorkInfoApiModel) = WorkInfoModel(
        title = apiModel.title,
        seasonName = apiModel.seasonName,
        episodes = apiModel.episodes,
        watchers = apiModel.watchers,
        reviews = apiModel.reviews,
    )

    fun toDataModel(apiModel: WorkInfoResponseApiModel): List<WorkInfoModel> =
        apiModel.workInfoList.map(::toDataModel)
}
