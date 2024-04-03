package jp.co.yumemi.data.models

import kotlinx.serialization.Serializable

@Serializable
data class WorkDetailsListModel(
    val title: String,
    val seasonName: String,
    val episodes: Int,
    val watchers: Int,
    val reviews: Int,
)
