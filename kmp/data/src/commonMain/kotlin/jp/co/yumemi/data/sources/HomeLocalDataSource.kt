package jp.co.yumemi.data.sources

import jp.co.yumemi.data.models.HomeModel

interface HomeLocalDataSource {
    suspend fun getDatabaseHomeWorkList(id: Int): List<HomeModel>
}
