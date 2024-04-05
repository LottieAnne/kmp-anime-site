package jp.co.yumemi.data.sources

import jp.co.yumemi.data.models.WorkEpisodeListModel
import jp.co.yumemi.data.models.WorkInfoModel

interface WorkDetailsRemoteDataSource {
    suspend fun getWorkInfo(): WorkInfoModel
    suspend fun getWorkEpisodeList(): List<WorkEpisodeListModel>
}
