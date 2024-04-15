package jp.co.yumemi.remote.providers

import jp.co.yumemi.data.core.runHandling
import jp.co.yumemi.data.models.WorkEpisodeListModel
import jp.co.yumemi.data.sources.WorkEpisodeListRemoteDataSource
import jp.co.yumemi.remote.apis.WorkEpisodeListApi
import jp.co.yumemi.remote.core.exception.RemoteExceptionHandler
import jp.co.yumemi.remote.mappers.WorkEpisodeListRemoteMapper

class WorkEpisodeListRemoteDataProvider(
    private val workEpisodeListApi: WorkEpisodeListApi,
    private val exceptionHandler: RemoteExceptionHandler,
) : WorkEpisodeListRemoteDataSource {
    override suspend fun getWorkEpisodeList(id: Int): List<WorkEpisodeListModel> =
        runHandling(exceptionHandler) {
            workEpisodeListApi.getWorkEpisodeList(id).body()
                .let(WorkEpisodeListRemoteMapper::toDataModel)
        }
}
