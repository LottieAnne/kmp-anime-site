package jp.co.yumemi.domain.repositories

import jp.co.yumemi.domain.entities.WorkDetailsEntity

interface WorkDetailsListRepository {
    suspend fun getWorkDetailsList(): List<WorkDetailsEntity>
}
