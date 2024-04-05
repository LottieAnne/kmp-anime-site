package jp.co.yumemi.workDetails

import jp.co.yumemi.domain.core.ErrorHandler
import jp.co.yumemi.domain.core.execute
import jp.co.yumemi.domain.core.runHandling
import jp.co.yumemi.domain.entities.WorkInfoEntity
import jp.co.yumemi.domain.usecases.GetWorkEpisodeListUseCase
import jp.co.yumemi.domain.usecases.GetWorkInfoUseCase
import jp.co.yumemi.domain.usecases.GetWorkListUseCase
import tech.fika.macaron.statemachine.components.StateMachine
import tech.fika.macaron.statemachine.components.event
import tech.fika.macaron.statemachine.components.result

class WorkDetailsStateMachine(
    private val getWorkInfoUseCase: GetWorkInfoUseCase,
    private val getWorkEpisodeListUseCase: GetWorkEpisodeListUseCase,
    private val errorHandler: ErrorHandler,
) : StateMachine<WorkDetailsIntent, WorkDetailsAction, WorkDetailsResult, WorkDetailsState, WorkDetailsEvent>(
    builder = {
        state<WorkDetailsState> {
            interpret<WorkDetailsIntent.ClickBack> { WorkDetailsAction.NavigateBack }

            process<WorkDetailsAction.NavigateBack> { event(WorkDetailsEvent.NavigateBack) }
        }
        state<WorkDetailsState.Initial> {
            interpret<WorkDetailsIntent.OnStart> { WorkDetailsAction.GetWorkDetails }

            // TODO: process実装

            reduce<WorkDetailsResult.Loading> { WorkDetailsState.Loading }
        }

        state<WorkDetailsState.Loading> {
            reduce<WorkDetailsResult.GetWorkDetailsSuccess> {
                WorkDetailsState.Stable(
                    workInfo = result.workInfo,
                    workEpisodeList = result.workEpisodeList
                )
            }
            reduce<WorkDetailsResult.GetWorkDetailsError> { WorkDetailsState.Error(error = result.error) }
        }
    }
)
