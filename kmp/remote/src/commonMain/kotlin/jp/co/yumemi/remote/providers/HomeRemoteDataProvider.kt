package jp.co.yumemi.remote.providers

import jp.co.yumemi.data.core.runHandling
import jp.co.yumemi.data.sources.HomeRemoteDataSource
import jp.co.yumemi.remote.apis.HomeApi
import jp.co.yumemi.remote.core.exception.RemoteExceptionHandler
import jp.co.yumemi.remote.mappers.HomeRemoteMapper

class HomeRemoteDataProvider(
    private val homeApi: HomeApi,
    private val exceptionHandler: RemoteExceptionHandler,
) : HomeRemoteDataSource {
    override suspend fun getHomeWorkList(id: Int) = runHandling(exceptionHandler) {
        homeApi.getHomeWorkList(id).body().workList.map(HomeRemoteMapper::toDataModel)
        homeApi.getHomeWorkList(id).body().let(HomeRemoteMapper::toDataModel)
    }
}
