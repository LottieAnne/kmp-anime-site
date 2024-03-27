package jp.co.yumemi.data.repositories

import jp.co.yumemi.data.mappers.WorkListDataMapper
import jp.co.yumemi.data.sources.WorkListRemoteDataSource
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.domain.repositories.WorkListRepository
import kotlinx.coroutines.delay

class WorkListDataRepository(
    private val workListRemoteDataSource: WorkListRemoteDataSource,
) : WorkListRepository {
    override suspend fun getWorkList(): List<WorkEntity> {
        // Mock
        delay(2_000L)
        return workListRemoteDataSource.getWorkList().map(WorkListDataMapper::toEntity)
    }
}
