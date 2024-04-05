package jp.co.yumemi.data.repositories

import jp.co.yumemi.data.mappers.WorkEpisodeListDataMapper
import jp.co.yumemi.data.sources.WorkEpisodeListRemoteDataSource
import jp.co.yumemi.domain.entities.WorkEpisodeEntity
import jp.co.yumemi.domain.repositories.WorkDetailsRepository
import kotlinx.coroutines.delay

class WorkDetailsDataRepository(
    private val workEpisodeListRemoteDataSource: WorkEpisodeListRemoteDataSource,
) : WorkDetailsRepository {

    override suspend fun getWorkEpisodeList(id: Int): List<WorkEpisodeEntity> {
        // Mock
        delay(2_000L)
        return workEpisodeListRemoteDataSource.getWorkEpisodeList(id)
            .map(WorkEpisodeListDataMapper::toEntity)
    }
}
