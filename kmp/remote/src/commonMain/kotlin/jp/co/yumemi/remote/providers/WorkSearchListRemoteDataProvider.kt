package jp.co.yumemi.remote.providers

import jp.co.yumemi.data.core.runHandling
import jp.co.yumemi.data.models.WorkListModel
import jp.co.yumemi.data.sources.WorkSearchListRemoteDataSource
import jp.co.yumemi.remote.apis.WorkSearchListApi
import jp.co.yumemi.remote.core.exception.RemoteExceptionHandler
import jp.co.yumemi.remote.mappers.WorkSearchListRemoteMapper

class WorkSearchListRemoteDataProvider(
    private val workSearchListApi: WorkSearchListApi,
    private val exceptionHandler: RemoteExceptionHandler,
) : WorkSearchListRemoteDataSource {
    override suspend fun getSearchWorkList(title: String): List<WorkListModel> =
        runHandling(exceptionHandler) {
            workSearchListApi.getSearchWorkList(title).body()
                .let(WorkSearchListRemoteMapper::toDataModel)
        }
}
