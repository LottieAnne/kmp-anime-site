package jp.co.yumemi.remote.providers

import jp.co.yumemi.data.core.runHandling
import jp.co.yumemi.data.sources.WorkRemoteDataSource
import jp.co.yumemi.remote.apis.WorkListApi
import jp.co.yumemi.remote.core.exception.RemoteExceptionHandler
import jp.co.yumemi.remote.mappers.WorkListRemoteMapper

class WorkRemoteDataProvider(
    private val workListApi: WorkListApi,
    private val exceptionHandler: RemoteExceptionHandler,
) : WorkRemoteDataSource {
    override suspend fun getWorkList() = runHandling(exceptionHandler) {
        workListApi.getWorkList().body().let(WorkListRemoteMapper::toDataModel)
    }
}
