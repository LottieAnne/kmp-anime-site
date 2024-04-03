package jp.co.yumemi.data.repositories

import jp.co.yumemi.data.mappers.WorkDetailsListDataMapper
import jp.co.yumemi.data.sources.WorkDetailsListRemoteDataSource
import jp.co.yumemi.domain.entities.WorkDetailsEntity
import jp.co.yumemi.domain.repositories.WorkDetailsListRepository
import kotlinx.coroutines.delay

class WorkDetailsListDataListRepository(
    private val workDetailsListDataSource: WorkDetailsListRemoteDataSource,
) : WorkDetailsListRepository {
    override suspend fun getWorkDetailsList(): List<WorkDetailsEntity> {
        // Mock
        delay(2_000L)
        return workDetailsListDataSource.getWorkDetailsList()
            .map(WorkDetailsListDataMapper::toEntity)
    }
}
