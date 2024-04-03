package jp.co.yumemi.data.sources

import jp.co.yumemi.data.models.WorkDetailsListModel

interface WorkDetailsListRemoteDataSource {
    suspend fun getWorkDetailsList(): List<WorkDetailsListModel>
}
