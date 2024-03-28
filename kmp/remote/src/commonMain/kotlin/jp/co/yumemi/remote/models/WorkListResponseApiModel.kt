package jp.co.yumemi.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorkListResponseApiModel(
    @SerialName("works")
    val workList: List<WorkApiModel>
)

