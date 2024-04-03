package jp.co.yumemi.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorkEpisodeApiModel(
    @SerialName(value = "title")
    val episodeTitle: String,
    @SerialName(value = "number_text")
    val episodeNumber: String,
)
