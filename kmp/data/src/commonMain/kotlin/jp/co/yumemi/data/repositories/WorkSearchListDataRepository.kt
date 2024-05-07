package jp.co.yumemi.data.repositories

import jp.co.yumemi.data.mappers.WorkListDataMapper
import jp.co.yumemi.data.sources.WorkSearchListRemoteDataSource
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.domain.repositories.WorkSearchListRepository
import kotlinx.coroutines.delay

class WorkSearchListDataRepository(
    private val workSearchListRemoteDataSource: WorkSearchListRemoteDataSource,
) : WorkSearchListRepository {
    override suspend fun getSearchWorkList(title: String): List<WorkEntity> {
        // Mock
        delay(2_000L)
        return workSearchListRemoteDataSource.getSearchWorkList(title).map(WorkListDataMapper::toEntity)
    }
}
