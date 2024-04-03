package jp.co.yumemi.data.models

import kotlinx.serialization.Serializable

@Serializable
data class WorkEpisodeListModel(
    val episodeNumber: String,
    val episodeTitle: String,
)
