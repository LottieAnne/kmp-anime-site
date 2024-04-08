package jp.co.yumemi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ServiceComponent
import jp.co.yumemi.domain.repositories.SampleRepository
import jp.co.yumemi.domain.repositories.SplashRepository
import jp.co.yumemi.domain.repositories.WorkDetailsRepository
import jp.co.yumemi.domain.repositories.WorkListRepository
import jp.co.yumemi.domain.usecases.CheckFirstUseExecutor
import jp.co.yumemi.domain.usecases.CheckFirstUseUseCase
import jp.co.yumemi.domain.usecases.GetWorkEpisodeListExecutor
import jp.co.yumemi.domain.usecases.GetWorkEpisodeListUseCase
import jp.co.yumemi.domain.usecases.GetWorkListExecutor
import jp.co.yumemi.domain.usecases.GetWorkListUseCase
import jp.co.yumemi.domain.usecases.SampleExecutor
import jp.co.yumemi.domain.usecases.SampleUseCase
import jp.co.yumemi.domain.usecases.SetFirstUseExecutor
import jp.co.yumemi.domain.usecases.SetFirstUseUseCase

@Module
@InstallIn(ActivityRetainedComponent::class, ServiceComponent::class)
class DomainModule {
    @Provides
    fun provideSampleUseCase(
        sampleRepository: SampleRepository,
    ): SampleUseCase = SampleExecutor(sampleRepository = sampleRepository)

    @Provides
    fun provideSetFirstLaunchExecutor(splashRepository: SplashRepository): SetFirstUseUseCase =
        SetFirstUseExecutor(splashRepository = splashRepository)

    @Provides
    fun provideGetFirstLaunchUseCase(splashRepository: SplashRepository): CheckFirstUseUseCase =
        CheckFirstUseExecutor(splashRepository = splashRepository)

    @Provides
    fun provideHomeUseCase(
        workListRepository: WorkListRepository,
    ): GetWorkListUseCase = GetWorkListExecutor(workListRepository = workListRepository)

    @Provides
    fun provideWorkDetailsUseCase(
        workEpisodeListRepository: WorkDetailsRepository,
    ): GetWorkEpisodeListUseCase =
        GetWorkEpisodeListExecutor(workEpisodeListRepository = workEpisodeListRepository)
}
