package jp.co.yumemi.data.sources

import jp.co.yumemi.data.models.WorkListModel

interface WorkSearchListRemoteDataSource {
    suspend fun getSearchWorkList(title: String): List<WorkListModel>
}
