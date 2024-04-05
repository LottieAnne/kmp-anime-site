package jp.co.yumemi.data.models

import kotlinx.serialization.Serializable

@Serializable
data class WorkListModel(
    val id: Int,
    val title: String,
    val seasonName: String,
    val imageUrl: String?,
    val episodes: Int,
    val watchers: Int,
    val reviews: Int,
)
