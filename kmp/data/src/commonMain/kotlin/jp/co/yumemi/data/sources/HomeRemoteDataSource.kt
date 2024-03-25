package jp.co.yumemi.data.sources

import jp.co.yumemi.data.models.HomeModel

interface HomeRemoteDataSource {
    suspend fun getHomeWorkList(id: Int): List<HomeModel>
}
