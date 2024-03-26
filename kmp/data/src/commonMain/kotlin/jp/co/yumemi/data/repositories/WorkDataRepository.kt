package jp.co.yumemi.data.repositories

import jp.co.yumemi.data.mappers.WorkListDataMapper
import jp.co.yumemi.data.sources.WorkRemoteDataSource
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.domain.repositories.WorkRepository
import kotlinx.coroutines.delay

class WorkDataRepository(
    private val workRemoteDataSource: WorkRemoteDataSource,
) : WorkRepository {
    override suspend fun getWorkList(): List<WorkEntity> {
        // Mock
        delay(2_000L)
        return workRemoteDataSource.getWorkList().map(WorkListDataMapper::toEntity)
    }
}
