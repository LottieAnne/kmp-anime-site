package jp.co.yumemi.domain.repositories

import jp.co.yumemi.domain.entities.WorkEpisodeEntity

interface WorkEpisodeListRepository {
    suspend fun getWorkEpisodeList(): List<WorkEpisodeEntity>
}
