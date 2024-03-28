package jp.co.yumemi.features.home

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.co.yumemi.core.foundation.StoreViewModel
import jp.co.yumemi.home.HomeEvent
import jp.co.yumemi.home.HomeIntent
import jp.co.yumemi.home.HomeState
import jp.co.yumemi.home.HomeStateMachine
import tech.fika.macaron.core.components.Store
import tech.fika.macaron.core.factory.StoreFactory
import tech.fika.macaron.logging.Logger
import tech.fika.macaron.logging.LoggingMiddleware
import tech.fika.macaron.statemachine.components.create
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    storeFactory: StoreFactory,
    stateMachine: HomeStateMachine,
) : StoreViewModel<HomeIntent, HomeState, HomeEvent>() {
    override val store: Store<HomeIntent, HomeState, HomeEvent> = storeFactory.create(
        initialState = HomeState.Initial,
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
