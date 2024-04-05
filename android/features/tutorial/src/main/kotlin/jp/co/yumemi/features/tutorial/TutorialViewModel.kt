package jp.co.yumemi.features.tutorial

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.co.yumemi.core.foundation.StoreViewModel
import jp.co.yumemi.tutorial.TutorialEvent
import jp.co.yumemi.tutorial.TutorialIntent
import jp.co.yumemi.tutorial.TutorialState
import jp.co.yumemi.tutorial.TutorialStateMachine
import tech.fika.macaron.core.components.Store
import tech.fika.macaron.core.factory.StoreFactory
import tech.fika.macaron.logging.Logger
import tech.fika.macaron.logging.LoggingMiddleware
import tech.fika.macaron.statemachine.components.create
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TutorialViewModel @Inject constructor(
    storeFactory: StoreFactory,
    stateMachine: TutorialStateMachine,
) : StoreViewModel<TutorialIntent, TutorialState, TutorialEvent>() {
    override val store: Store<TutorialIntent, TutorialState, TutorialEvent> = storeFactory.create(
        initialState = TutorialState.Stable,
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
