package jp.co.yumemi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ServiceComponent
import jp.co.yumemi.data.sources.SampleRemoteDataSource
import jp.co.yumemi.data.sources.WorkEpisodeListRemoteDataSource
import jp.co.yumemi.data.sources.WorkListRemoteDataSource
import jp.co.yumemi.remote.apis.SampleApi
import jp.co.yumemi.remote.apis.WorkEpisodeListApi
import jp.co.yumemi.remote.apis.WorkListApi
import jp.co.yumemi.remote.core.exception.RemoteExceptionHandler
import jp.co.yumemi.remote.providers.SampleRemoteDataProvider
import jp.co.yumemi.remote.providers.WorkEpisodeListRemoteDataProvider
import jp.co.yumemi.remote.providers.WorkListRemoteDataProvider

@Module
@InstallIn(ActivityRetainedComponent::class, ServiceComponent::class)
class RemoteModule {
    @Provides
    fun provideRemoteExceptionHandler(): RemoteExceptionHandler = RemoteExceptionHandler()

    @Provides
    fun provideSampleRemoteDataSource(
        sampleApi: SampleApi,
        exceptionHandler: RemoteExceptionHandler,
    ): SampleRemoteDataSource = SampleRemoteDataProvider(
        sampleApi = sampleApi,
        exceptionHandler = exceptionHandler,
    )

    @Provides
    fun provideHomeRemoteDataSource(
        workListApi: WorkListApi,
        exceptionHandler: RemoteExceptionHandler,
    ): WorkListRemoteDataSource = WorkListRemoteDataProvider(
        workListApi = workListApi,
        exceptionHandler = exceptionHandler,
    )

    @Provides
    fun provideWorkEpisodeRemoteDataSource(
        workEpisodeListApi: WorkEpisodeListApi,
        exceptionHandler: RemoteExceptionHandler,
    ): WorkEpisodeListRemoteDataSource = WorkEpisodeListRemoteDataProvider(
        workEpisodeListApi = workEpisodeListApi,
        exceptionHandler = exceptionHandler
    )
}
