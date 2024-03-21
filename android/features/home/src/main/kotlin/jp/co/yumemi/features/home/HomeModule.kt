package jp.co.yumemi.features.home

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.domain.core.ErrorHandler
import jp.co.yumemi.domain.usecases.HomeUseCase
import jp.co.yumemi.home.HomeStateMachine

@Module
@InstallIn(ActivityRetainedComponent::class)
class HomeModule {
    @Provides
    fun provideHomeStateMachine(
        homeUseCase: HomeUseCase,
        errorHandler: ErrorHandler,
    ): HomeStateMachine = HomeStateMachine(
        homeUseCase = homeUseCase,
        errorHandler = errorHandler,
    )
}
