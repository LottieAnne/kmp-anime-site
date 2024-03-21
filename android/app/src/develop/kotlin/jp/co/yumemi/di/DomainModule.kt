package jp.co.yumemi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ServiceComponent
import jp.co.yumemi.domain.repositories.HomeRepository
import jp.co.yumemi.domain.repositories.SampleRepository
import jp.co.yumemi.domain.usecases.HomeExecutor
import jp.co.yumemi.domain.usecases.HomeUseCase
import jp.co.yumemi.domain.usecases.SampleExecutor
import jp.co.yumemi.domain.usecases.SampleUseCase

@Module
@InstallIn(ActivityRetainedComponent::class, ServiceComponent::class)
class DomainModule {
    @Provides
    fun provideSampleUseCase(
        sampleRepository: SampleRepository,
    ): SampleUseCase = SampleExecutor(sampleRepository = sampleRepository)

    @Provides
    fun provideHomeUseCase(
        homeRepository: HomeRepository,
    ): HomeUseCase = HomeExecutor(homeRepository = homeRepository)
}
