package jp.co.yumemi.domain.repositories

import jp.co.yumemi.domain.entities.WorkEntity

interface WorkRepository {
    suspend fun getWorkList(): List<WorkEntity>
}
