package jp.co.yumemi.data.repositories

import jp.co.yumemi.data.mappers.WorkEpisodeListDataMapper
import jp.co.yumemi.data.mappers.WorkInfoDataMapper
import jp.co.yumemi.data.mappers.WorkListDataMapper
import jp.co.yumemi.data.sources.WorkDetailsRemoteDataSource
import jp.co.yumemi.data.sources.WorkListRemoteDataSource
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.domain.entities.WorkEpisodeEntity
import jp.co.yumemi.domain.entities.WorkInfoEntity
import jp.co.yumemi.domain.repositories.WorkDetailsRepository
import jp.co.yumemi.domain.repositories.WorkListRepository
import kotlinx.coroutines.delay

class WorkDetailsDataRepository(
    private val workDetailsRemoteDataSource: WorkDetailsRemoteDataSource,
) : WorkDetailsRepository {
    override suspend fun getWorkInfo(): WorkInfoEntity {
        // Mock
        delay(2_000L)
        return workDetailsRemoteDataSource.getWorkInfo().let(WorkInfoDataMapper::toEntity)
    }

    override suspend fun getWorkEpisodeList(): List<WorkEpisodeEntity> {
        // Mock
        delay(2_000L)
        return workDetailsRemoteDataSource.getWorkEpisodeList()
            .map(WorkEpisodeListDataMapper::toEntity)
    }
}
