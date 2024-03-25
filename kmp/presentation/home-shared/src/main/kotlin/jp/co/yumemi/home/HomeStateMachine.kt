package jp.co.yumemi.home

import jp.co.yumemi.domain.core.ErrorHandler
import jp.co.yumemi.domain.core.runHandling
import jp.co.yumemi.domain.usecases.HomeUseCase
import tech.fika.macaron.statemachine.components.StateMachine
import tech.fika.macaron.statemachine.components.result

class HomeStateMachine(
    private val homeUseCase: HomeUseCase,
    private val errorHandler: ErrorHandler,
) : StateMachine<
        HomeIntent,
        HomeAction,
        HomeResult,
        HomeState,
        HomeEvent>(
    builder = {
        state<HomeState.Initial> {
            process<HomeAction.GetHomeWorkList> {
                result(HomeResult.Loading)
                runHandling(errorHandler) {
                    homeUseCase.execute(arguments = HomeUseCase.Args(id = 1))
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
            //TODO: 後から実装
        }
    }
)
