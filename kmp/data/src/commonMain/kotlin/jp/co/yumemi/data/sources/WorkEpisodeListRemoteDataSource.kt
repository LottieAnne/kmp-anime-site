package jp.co.yumemi.data.sources

import jp.co.yumemi.data.models.WorkEpisodeListModel

interface WorkDetailsRemoteDataSource {
    suspend fun getWorkEpisodeList(id: Int): List<WorkEpisodeListModel>
}
