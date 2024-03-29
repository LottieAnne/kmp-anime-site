package jp.co.yumemi.features.splash

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.domain.usecases.CheckFirstUseUseCase
import jp.co.yumemi.domain.usecases.SetFirstUseUseCase
import jp.co.yumemi.splash.SplashStateMachine

@Module
@InstallIn(ActivityRetainedComponent::class)
class SplashModule {
    @Provides
    fun provideSplashStateMachine(
        checkFirstUseUseCase: CheckFirstUseUseCase,
        setFirstUseUseCase: SetFirstUseUseCase,
    ): SplashStateMachine = SplashStateMachine(
        checkFirstUseUseCase = checkFirstUseUseCase,
        setFirstUseUseCase = setFirstUseUseCase,
    )
}
