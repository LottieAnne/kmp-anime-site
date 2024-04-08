package jp.co.yumemi.features.workDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.co.yumemi.core.foundation.StoreViewModel
import jp.co.yumemi.workDetails.WorkDetailsEvent
import jp.co.yumemi.workDetails.WorkDetailsIntent
import jp.co.yumemi.workDetails.WorkDetailsState
import jp.co.yumemi.workDetails.WorkDetailsStateMachine
import tech.fika.macaron.core.components.Store
import tech.fika.macaron.core.factory.StoreFactory
import tech.fika.macaron.logging.Logger
import tech.fika.macaron.logging.LoggingMiddleware
import tech.fika.macaron.statemachine.components.create
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class WorkDetailsViewModel @Inject constructor(
    storeFactory: StoreFactory,
    stateMachine: WorkDetailsStateMachine,
    savedStateHandle: SavedStateHandle,
) : StoreViewModel<WorkDetailsIntent, WorkDetailsState, WorkDetailsEvent>() {
    private val args = WorkDetailsFragmentArgs.fromSavedStateHandle(savedStateHandle = savedStateHandle)

    override val store: Store<WorkDetailsIntent, WorkDetailsState, WorkDetailsEvent> = storeFactory.create(
        initialState = WorkDetailsState.Initial(
            work = args.work
        ),
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
