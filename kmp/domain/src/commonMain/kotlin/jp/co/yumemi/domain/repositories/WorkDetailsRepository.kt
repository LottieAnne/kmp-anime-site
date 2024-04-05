package jp.co.yumemi.domain.repositories

import jp.co.yumemi.domain.entities.WorkEpisodeEntity
import jp.co.yumemi.domain.entities.WorkInfoEntity

interface WorkDetailsRepository {
    suspend fun getWorkInfo(): WorkInfoEntity
    suspend fun getWorkEpisodeList(): List<WorkEpisodeEntity>
}
