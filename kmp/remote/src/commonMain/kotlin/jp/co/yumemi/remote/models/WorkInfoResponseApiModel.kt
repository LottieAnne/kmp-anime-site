package jp.co.yumemi.remote.models

import jp.co.yumemi.data.models.WorkInfoModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorkInfoResponseApiModel(
    @SerialName("works")
    val workInfoList: List<WorkInfoApiModel>
)

