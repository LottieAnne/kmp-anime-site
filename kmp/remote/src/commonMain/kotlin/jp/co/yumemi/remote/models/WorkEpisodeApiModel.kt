package jp.co.yumemi.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorkEpisodeApiModel(
    @SerialName(value = "number_text")
    val episodeNumber: String,
    @SerialName(value = "title")
    val episodeTitle: String,
)
