package jp.co.yumemi.data.sources

import jp.co.yumemi.data.models.WorkListModel

interface WorkRemoteDataSource {
    suspend fun getWorkList(): List<WorkListModel>
}
