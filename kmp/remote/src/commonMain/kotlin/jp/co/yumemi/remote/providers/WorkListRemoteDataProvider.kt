package jp.co.yumemi.remote.providers

import jp.co.yumemi.data.core.runHandling
import jp.co.yumemi.data.sources.WorkListRemoteDataSource
import jp.co.yumemi.remote.apis.WorkListApi
import jp.co.yumemi.remote.core.exception.RemoteExceptionHandler
import jp.co.yumemi.remote.mappers.WorkListRemoteMapper

class WorkListRemoteDataProvider(
    private val workListApi: WorkListApi,
    private val exceptionHandler: RemoteExceptionHandler,
) : WorkListRemoteDataSource {
    override suspend fun getWorkList() = runHandling(exceptionHandler) {
        workListApi.getWorkList().body().let(WorkListRemoteMapper::toDataModel)
    }
}
