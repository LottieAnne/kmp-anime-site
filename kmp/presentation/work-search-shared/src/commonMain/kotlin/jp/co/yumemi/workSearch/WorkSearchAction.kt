package jp.co.yumemi.workSearch

import jp.co.yumemi.domain.entities.WorkEntity
import tech.fika.macaron.core.contract.Action

sealed class WorkSearchAction : Action {
    data object ShowInputSearchText : WorkSearchAction()
    data object CloseInputSearchText : WorkSearchAction()
    data class UpdateSearchText(val text: String) : WorkSearchAction()
    data class GetWorkSearchList(val searchTitle: String) : WorkSearchAction()
    data object NavigateBack : WorkSearchAction()
    data class NavigateDetails(val listItem: WorkEntity) : WorkSearchAction()
}
