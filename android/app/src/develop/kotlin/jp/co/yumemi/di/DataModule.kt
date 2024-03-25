package jp.co.yumemi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ServiceComponent
import jp.co.yumemi.data.repositories.HomeDataRepository
import jp.co.yumemi.data.repositories.SampleDataRepository
import jp.co.yumemi.data.sources.HomeLocalDataSource
import jp.co.yumemi.data.sources.HomeRemoteDataSource
import jp.co.yumemi.data.sources.SampleLocalDataSource
import jp.co.yumemi.data.sources.SampleRemoteDataSource
import jp.co.yumemi.domain.repositories.HomeRepository
import jp.co.yumemi.domain.repositories.SampleRepository

@Module
@InstallIn(ActivityRetainedComponent::class, ServiceComponent::class)
class DataModule {
    @Provides
    fun provideSampleRepository(
        sampleLocalDataSource: SampleLocalDataSource,
        sampleRemoteDataSource: SampleRemoteDataSource,
    ): SampleRepository = SampleDataRepository(
        sampleLocalDataSource = sampleLocalDataSource,
        sampleRemoteDataSource = sampleRemoteDataSource
    )

    @Provides
    fun provideHomeRepository(
        homeLocalDataSource: HomeLocalDataSource,
        homeRemoteDataSource: HomeRemoteDataSource,
    ): HomeRepository = HomeDataRepository(
        homeLocalDataSource = homeLocalDataSource,
        homeRemoteDataSource = homeRemoteDataSource,
    )
}
