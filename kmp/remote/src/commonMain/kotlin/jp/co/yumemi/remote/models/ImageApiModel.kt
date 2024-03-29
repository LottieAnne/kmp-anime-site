package jp.co.yumemi.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageApiModel(
    @SerialName("recommended_url")
    val imageUrl: String,
)
