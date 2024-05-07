package jp.co.yumemi.domain.repositories

import jp.co.yumemi.domain.entities.WorkEntity

interface WorkSearchListRepository {
    suspend fun getSearchWorkList(title: String): List<WorkEntity>
}
