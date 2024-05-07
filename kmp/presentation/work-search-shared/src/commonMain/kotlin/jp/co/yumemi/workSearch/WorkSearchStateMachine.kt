package jp.co.yumemi.workSearch

import jp.co.yumemi.domain.core.ErrorHandler
import jp.co.yumemi.domain.core.runHandling
import jp.co.yumemi.domain.usecases.GetSearchWorkListUseCase
import tech.fika.macaron.statemachine.components.StateMachine
import tech.fika.macaron.statemachine.components.event
import tech.fika.macaron.statemachine.components.result

class WorkSearchStateMachine(
    private val getSearchWorkListUseCase: GetSearchWorkListUseCase,
    private val errorHandler: ErrorHandler,
) : StateMachine<WorkSearchIntent, WorkSearchAction, WorkSearchResult, WorkSearchState, WorkSearchEvent>(
    builder = {
        state<WorkSearchState> {
            interpret<WorkSearchIntent.ClickBack> { WorkSearchAction.NavigateBack }

            process<WorkSearchAction.NavigateBack> { event(WorkSearchEvent.NavigateBack) }
        }
        state<WorkSearchState.Initial> {
            interpret<WorkSearchIntent.ClickBack> { WorkSearchAction.NavigateBack }
            interpret<WorkSearchIntent.OnFocusSearchTextField> { WorkSearchAction.ShowInputSearchText }
            interpret<WorkSearchIntent.ClickClearSearchText> { WorkSearchAction.UpdateSearchText("") }
            interpret<WorkSearchIntent.OnUnfocusSearchTextField> { WorkSearchAction.CloseInputSearchText }
            interpret<WorkSearchIntent.InputSearchText> { WorkSearchAction.UpdateSearchText(text = intent.text) }
            interpret<WorkSearchIntent.ClickSearch> {
                WorkSearchAction.GetWorkSearchList(
                    searchTitle = intent.searchTitle
                )
            }

            process<WorkSearchAction.GetWorkSearchList> {
                result(WorkSearchResult.Loading)
                runHandling(errorHandler) {
                    getSearchWorkListUseCase.execute(arguments = GetSearchWorkListUseCase.Args(title = it.action.searchTitle))
                }.onSuccess { list ->
                    result(
                        WorkSearchResult.GetWorkSearchSuccess(
                            searchText = it.action.searchTitle,
                            workSearchList = list,
                        )
                    )
                }.onFailure { error ->
                    result(
                        WorkSearchResult.GetWorkSearchError(
                            searchText = it.action.searchTitle,
                            error = error
                        )
                    )
                }
            }

            reduce<WorkSearchResult.Loading> { WorkSearchState.Loading }
        }

        state<WorkSearchState.Loading> {
            reduce<WorkSearchResult.GetWorkSearchSuccess> {
                WorkSearchState.Stable(
                    searchText = result.searchText,
                    searchWork = result.workSearchList,
                )
            }
            reduce<WorkSearchResult.GetWorkSearchError> {
                WorkSearchState.Error(
                    searchText = result.searchText,
                    error = result.error
                )
            }
        }

        state<WorkSearchState.Stable> {
            interpret<WorkSearchIntent.ClickListItem> { WorkSearchAction.NavigateDetails(intent.listItem) }
            process<WorkSearchAction.NavigateDetails> {
                event(WorkSearchEvent.NavigateDetails(it.action.listItem))
            }
        }
    }
)
