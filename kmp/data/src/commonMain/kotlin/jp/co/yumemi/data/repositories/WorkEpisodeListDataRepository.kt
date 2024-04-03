package jp.co.yumemi.data.repositories

import jp.co.yumemi.data.mappers.WorkEpisodeListDataMapper
import jp.co.yumemi.data.sources.WorkEpisodeListRemoteDataSource
import jp.co.yumemi.domain.entities.WorkEpisodeEntity
import jp.co.yumemi.domain.repositories.WorkEpisodeListRepository
import kotlinx.coroutines.delay

class WorkEpisodeListDataRepository(
    private val workEpisodeListDataSource: WorkEpisodeListRemoteDataSource,
) : WorkEpisodeListRepository {
    override suspend fun getWorkEpisodeList(): List<WorkEpisodeEntity> {
        // Mock
        delay(2_000L)
        return workEpisodeListDataSource.getWorkEpisodeList()
            .map(WorkEpisodeListDataMapper::toEntity)
    }
}
