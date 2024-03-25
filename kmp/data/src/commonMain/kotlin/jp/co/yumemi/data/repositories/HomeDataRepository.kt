package jp.co.yumemi.data.repositories

import jp.co.yumemi.data.mappers.HomeDataMapper
import jp.co.yumemi.data.sources.HomeLocalDataSource
import jp.co.yumemi.data.sources.HomeRemoteDataSource
import jp.co.yumemi.domain.entities.HomeEntity
import jp.co.yumemi.domain.repositories.HomeRepository
import kotlinx.coroutines.delay

class HomeDataRepository(
    private val homeLocalDataSource: HomeLocalDataSource,
    private val homeRemoteDataSource: HomeRemoteDataSource,
) : HomeRepository {
    override suspend fun getHomeWorkList(id: Int): List<HomeEntity> {
        // Mock
        delay(2_000L)
        return homeRemoteDataSource.getHomeWorkList(id = id).map { HomeDataMapper.toEntity(model = it) }
    }
}
