package jp.co.yumemi.home

import jp.co.yumemi.domain.core.ErrorHandler
import jp.co.yumemi.domain.core.execute
import jp.co.yumemi.domain.core.runHandling
import jp.co.yumemi.domain.usecases.GetWorkListUseCase
import tech.fika.macaron.statemachine.components.StateMachine
import tech.fika.macaron.statemachine.components.event
import tech.fika.macaron.statemachine.components.result

class HomeStateMachine(
    private val getWorkListUseCase: GetWorkListUseCase,
    private val errorHandler: ErrorHandler,
) : StateMachine<
        HomeIntent,
        HomeAction,
        HomeResult,
        HomeState,
        HomeEvent>(
    builder = {
        state<HomeState.Initial> {
            interpret<HomeIntent.OnStart> { HomeAction.GetHomeWorkList }
            process<HomeAction.GetHomeWorkList> {
                result(HomeResult.Loading)
                runHandling(errorHandler) {
                    getWorkListUseCase.execute()
                }.onSuccess {
                    result(HomeResult.GetHomeWorkListSuccess(homeList = it))
                }.onFailure {
                    result(HomeResult.GetHomeWorkListError(error = it))
                }
            }

            reduce<HomeResult.Loading> { HomeState.Loading }
        }

        state<HomeState.Loading> {
            reduce<HomeResult.GetHomeWorkListSuccess> { HomeState.Stable(homeList = result.homeList) }
            reduce<HomeResult.GetHomeWorkListError> { HomeState.Error(error = result.error) }
        }

        state<HomeState.Stable> {
            interpret<HomeIntent.ClickListItem> { HomeAction.NavigateDetails(intent.listItem) }
            process<HomeAction.NavigateDetails> {
                event(HomeEvent.NavigateDetails(it.action.listItem))
            }
        }
    }
)
