package jp.co.yumemi.data.models

import kotlinx.serialization.Serializable

@Serializable
data class WorkListModel(
    val title: String,
    val seasonName: String,
    val imageUrl: String?,
)
