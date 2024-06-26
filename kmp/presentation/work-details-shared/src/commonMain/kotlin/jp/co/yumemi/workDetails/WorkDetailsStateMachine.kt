package jp.co.yumemi.workDetails

import jp.co.yumemi.domain.core.ErrorHandler
import jp.co.yumemi.domain.core.runHandling
import jp.co.yumemi.domain.usecases.GetWorkEpisodeListUseCase
import tech.fika.macaron.statemachine.components.StateMachine
import tech.fika.macaron.statemachine.components.event
import tech.fika.macaron.statemachine.components.result

class WorkDetailsStateMachine(
    private val getWorkEpisodeListUseCase: GetWorkEpisodeListUseCase,
    private val errorHandler: ErrorHandler,
) : StateMachine<WorkDetailsIntent, WorkDetailsAction, WorkDetailsResult, WorkDetailsState, WorkDetailsEvent>(
    builder = {
        state<WorkDetailsState> {
            interpret<WorkDetailsIntent.ClickBack> { WorkDetailsAction.NavigateBack }

            process<WorkDetailsAction.NavigateBack> { event(WorkDetailsEvent.NavigateBack) }
        }
//
        state<WorkDetailsState.Initial> {
            interpret<WorkDetailsIntent.OnStart> { WorkDetailsAction.GetWorkDetails }

            process<WorkDetailsAction.GetWorkDetails> {
                result(WorkDetailsResult.Loading)
                runHandling(errorHandler) {
                    getWorkEpisodeListUseCase.execute(arguments = GetWorkEpisodeListUseCase.Args(id = it.state.work.id))
                }.onSuccess {
                    result(
                        WorkDetailsResult.GetWorkDetailsSuccess(
                            workEpisodeList = it,
                        )
                    )
                }.onFailure {
                    result(WorkDetailsResult.GetWorkDetailsError(error = it))
                }
            }

            reduce<WorkDetailsResult.Loading> { WorkDetailsState.Loading(work = state.work) }
        }

        state<WorkDetailsState.Loading> {
            reduce<WorkDetailsResult.GetWorkDetailsSuccess> {
                WorkDetailsState.Stable(
                    work = state.work,
                    workEpisodeList = result.workEpisodeList
                )
            }
            reduce<WorkDetailsResult.GetWorkDetailsError> {
                WorkDetailsState.Error(
                    work = state.work,
                    error = result.error
                )
            }
        }
    }
)
