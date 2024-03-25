package jp.co.yumemi.data.repositories

import jp.co.yumemi.data.mappers.HomeDataMapper
import jp.co.yumemi.data.sources.HomeRemoteDataSource
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.domain.repositories.HomeRepository
import kotlinx.coroutines.delay

class HomeDataRepository(
    private val homeRemoteDataSource: HomeRemoteDataSource,
) : HomeRepository {
    override suspend fun getHomeWorkList(id: Int): List<WorkEntity> {
        // Mock
        delay(2_000L)
        return homeRemoteDataSource.getHomeWorkList(id = id).map { HomeDataMapper.toEntity(model = it) }
    }
}
