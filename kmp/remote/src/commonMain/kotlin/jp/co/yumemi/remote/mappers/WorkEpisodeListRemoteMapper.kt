package jp.co.yumemi.remote.mappers

import jp.co.yumemi.data.models.WorkEpisodeListModel
import jp.co.yumemi.data.models.WorkListModel
import jp.co.yumemi.remote.models.WorkApiModel
import jp.co.yumemi.remote.models.WorkEpisodeApiModel
import jp.co.yumemi.remote.models.WorkEpisodeListResponseApiModel
import jp.co.yumemi.remote.models.WorkListResponseApiModel

internal object WorkEpisodeListRemoteMapper {
    fun toDataModel(apiModel: WorkEpisodeApiModel) = WorkEpisodeListModel(
        episodeNumber = apiModel.episodeNumber,
        episodeTitle = apiModel.episodeTitle,
    )

    fun toDataModel(apiModel: WorkEpisodeListResponseApiModel): List<WorkEpisodeListModel> =
        apiModel.episodeList.map(::toDataModel)
}
