package jp.co.yumemi.workDetails

import jp.co.yumemi.domain.core.ErrorHandler
import jp.co.yumemi.domain.core.execute
import jp.co.yumemi.domain.core.runHandling
import jp.co.yumemi.domain.usecases.GetWorkDetailsListUseCase
import jp.co.yumemi.domain.usecases.GetWorkEpisodeListUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import tech.fika.macaron.statemachine.components.StateMachine
import tech.fika.macaron.statemachine.components.result

class WorkDetailsStateMachine(
    private val getWorkDetailsListUseCase: GetWorkDetailsListUseCase,
    private val getWorkEpisodeListUseCase: GetWorkEpisodeListUseCase,
    private val errorHandler: ErrorHandler,
) : StateMachine<WorkDetailsIntent, WorkDetailsAction, WorkDetailsResult, WorkDetailsState, WorkDetailsEvent>(
    builder = {
        state<WorkDetailsState.Initial> {
            interpret<WorkDetailsIntent.OnStart> {
                WorkDetailsAction.GetWorkDetailsList
            }
            process<WorkDetailsAction.GetWorkDetailsList> {
                result(WorkDetailsResult.Loading)
                runHandling(errorHandler) {
                    coroutineScope {
                        val workDetailsList = async { getWorkDetailsListUseCase.execute() }
                        val workEpisodeList = async { getWorkEpisodeListUseCase.execute() }

                        WorkDetailsResult.GetWorkDetailsListSuccess(
                            workDetailsList = workDetailsList.await(),
                            workEpisodeList = workEpisodeList.await(),
                        )
                    }
                }.onSuccess {
                    result(it)
                }.onFailure {
                    result(WorkDetailsResult.GetWorkDetailsListError(error = it))
                }
            }
            reduce<WorkDetailsResult.Loading> { WorkDetailsState.Loading }
        }
        state<WorkDetailsState.Loading> {
            reduce<WorkDetailsResult.GetWorkDetailsListSuccess> {
                WorkDetailsState.Stable(
                    workDetailsList = result.workDetailsList,
                    workEpisodeList = result.workEpisodeList
                )
            }
            reduce<WorkDetailsResult.GetWorkDetailsListError> { WorkDetailsState.Error(error = result.error) }
        }
        state<WorkDetailsState.Stable> {}
    }
)
