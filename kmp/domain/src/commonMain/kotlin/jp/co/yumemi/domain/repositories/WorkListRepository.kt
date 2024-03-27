package jp.co.yumemi.domain.repositories

import jp.co.yumemi.domain.entities.WorkEntity

interface WorkListRepository {
    suspend fun getWorkList(): List<WorkEntity>
}
