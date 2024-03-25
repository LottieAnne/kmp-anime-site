package jp.co.yumemi.domain.repositories

import jp.co.yumemi.domain.entities.WorkEntity

interface HomeRepository {
    suspend fun getHomeWorkList(id: Int): List<WorkEntity>
}
