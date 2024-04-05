package jp.co.yumemi.features.splash

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.co.yumemi.core.foundation.StoreViewModel
import jp.co.yumemi.splash.SplashEvent
import jp.co.yumemi.splash.SplashIntent
import jp.co.yumemi.splash.SplashState
import jp.co.yumemi.splash.SplashStateMachine
import tech.fika.macaron.core.components.Store
import tech.fika.macaron.core.factory.StoreFactory
import tech.fika.macaron.logging.Logger
import tech.fika.macaron.logging.LoggingMiddleware
import tech.fika.macaron.statemachine.components.create
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    storeFactory: StoreFactory,
    stateMachine: SplashStateMachine,
) : StoreViewModel<SplashIntent, SplashState, SplashEvent>() {
    override val store: Store<SplashIntent, SplashState, SplashEvent> = storeFactory.create(
        initialState = SplashState.Stable,
        stateMachine = stateMachine,
        middlewares = listOf(
            LoggingMiddleware(
                object : Logger {
                    override fun log(level: Logger.Level, tag: String, message: () -> String) {
                        Timber.d(message())
                    }
                },
            ),
        ),
        coroutineContext = viewModelScope.coroutineContext,
    )
}
