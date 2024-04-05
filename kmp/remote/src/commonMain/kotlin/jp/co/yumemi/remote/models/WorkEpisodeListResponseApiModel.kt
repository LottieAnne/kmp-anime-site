package jp.co.yumemi.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorkEpisodeListResponseApiModel(
    @SerialName("episodes")
    val episodeList: List<WorkEpisodeApiModel>
)

