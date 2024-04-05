package jp.co.yumemi.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorkInfoApiModel(
    @SerialName(value = "title")
    val title: String,
    @SerialName(value = "season_name")
    val seasonName: String,
    @SerialName(value = "episodes_count")
    val episodes: Int,
    @SerialName(value = "watchers_count")
    val watchers: Int,
    @SerialName(value = "reviews_count")
    val reviews: Int,
)
