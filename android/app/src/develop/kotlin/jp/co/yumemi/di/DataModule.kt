package jp.co.yumemi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ServiceComponent
import jp.co.yumemi.data.repositories.SampleDataRepository
import jp.co.yumemi.data.repositories.SplashDataRepository
import jp.co.yumemi.data.repositories.WorkDetailsDataRepository
import jp.co.yumemi.data.repositories.WorkListDataRepository
import jp.co.yumemi.data.sources.SampleLocalDataSource
import jp.co.yumemi.data.sources.SampleRemoteDataSource
import jp.co.yumemi.data.sources.SplashLocalDataSource
import jp.co.yumemi.data.sources.WorkEpisodeListRemoteDataSource
import jp.co.yumemi.data.sources.WorkListRemoteDataSource
import jp.co.yumemi.domain.repositories.SampleRepository
import jp.co.yumemi.domain.repositories.SplashRepository
import jp.co.yumemi.domain.repositories.WorkDetailsRepository
import jp.co.yumemi.domain.repositories.WorkListRepository

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
    fun provideSplashRepository(
        splashLocalDataSource: SplashLocalDataSource,
    ): SplashRepository = SplashDataRepository(
        splashLocalDataSource = splashLocalDataSource,
    )

    @Provides
    fun provideWorkListRepository(
        workListRemoteDataSource: WorkListRemoteDataSource,
    ): WorkListRepository = WorkListDataRepository(
        workListRemoteDataSource = workListRemoteDataSource
    )

    @Provides
    fun provideWorkEpisodeListRepository(
        workEpisodeListRemoteDataSource: WorkEpisodeListRemoteDataSource,
    ): WorkDetailsRepository = WorkDetailsDataRepository(
        workEpisodeListRemoteDataSource = workEpisodeListRemoteDataSource
    )
}
