package jp.co.yumemi.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorkApiModel(
    @SerialName(value = "id")
    val id: Int,
    @SerialName(value = "title")
    val title: String,
    @SerialName(value = "season_name")
    val seasonName: String,
    @SerialName(value = "images")
    val image: ImageApiModel,
)
