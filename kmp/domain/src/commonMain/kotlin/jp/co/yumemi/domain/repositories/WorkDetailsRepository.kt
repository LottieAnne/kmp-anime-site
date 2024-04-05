package jp.co.yumemi.domain.repositories

import jp.co.yumemi.domain.entities.WorkEpisodeEntity

interface WorkDetailsRepository {
    suspend fun getWorkEpisodeList(id: Int): List<WorkEpisodeEntity>
}
