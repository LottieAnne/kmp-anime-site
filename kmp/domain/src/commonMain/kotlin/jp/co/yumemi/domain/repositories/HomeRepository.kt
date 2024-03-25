package jp.co.yumemi.domain.repositories

import jp.co.yumemi.domain.entities.HomeEntity

interface HomeRepository {
    suspend fun getHomeWorkList(id: Int): List<HomeEntity>
}
