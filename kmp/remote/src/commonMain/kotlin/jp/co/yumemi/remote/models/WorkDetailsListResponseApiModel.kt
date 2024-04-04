package jp.co.yumemi.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorkDetailsListResponseApiModel(
    @SerialName("works")
    val workDetailsList: List<WorkDetailsApiModel>
)

