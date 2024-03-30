package jp.co.yumemi.domain.repositories

import jp.co.yumemi.domain.entities.WorkEpisodeEntity

interface WorkEpisodeRepository {
    suspend fun getWorkEpisodeList(): List<WorkEpisodeEntity>
}
