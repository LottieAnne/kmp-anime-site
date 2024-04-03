package jp.co.yumemi.remote.mappers

import jp.co.yumemi.data.models.WorkEpisodeListModel
import jp.co.yumemi.remote.models.WorkEpisodeApiModel
import jp.co.yumemi.remote.models.WorkEpisodeListResponseApiModel

internal object WorkEpisodeListRemoteMapper {
    fun toDataModel(apiModel: WorkEpisodeApiModel) = WorkEpisodeListModel(
        episodeTitle = apiModel.episodeTitle,
        episodeNumber = apiModel.episodeNumber,
    )

    fun toDataModel(apiModel: WorkEpisodeListResponseApiModel): List<WorkEpisodeListModel> =
        apiModel.episodeList.map(::toDataModel)
}
