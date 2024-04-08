package jp.co.yumemi.features.workDetails

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.domain.core.ErrorHandler
import jp.co.yumemi.domain.usecases.GetWorkEpisodeListUseCase
import jp.co.yumemi.workDetails.WorkDetailsStateMachine

@Module
@InstallIn(ActivityRetainedComponent::class)
class WorkDetailsModule {
    @Provides
    fun provideWorkDetailsStateMachine(
        getWorkEpisodeListUseCase: GetWorkEpisodeListUseCase,
        errorHandler: ErrorHandler
    ): WorkDetailsStateMachine = WorkDetailsStateMachine(
        getWorkEpisodeListUseCase = getWorkEpisodeListUseCase,
        errorHandler = errorHandler
    )
}
