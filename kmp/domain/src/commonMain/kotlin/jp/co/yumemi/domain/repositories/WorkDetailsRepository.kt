package jp.co.yumemi.domain.repositories

import jp.co.yumemi.domain.entities.WorkDetailsEntity

interface WorkDetailsRepository {
    suspend fun getWorkDetails(): List<WorkDetailsEntity>
}
