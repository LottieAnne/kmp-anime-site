package jp.co.yumemi.workSearch

import jp.co.yumemi.domain.entities.WorkEntity
import tech.fika.macaron.core.contract.Intent

sealed class WorkSearchIntent : Intent {
    data object ClickBack: WorkSearchIntent()
    data object OnFocusSearchTextField : WorkSearchIntent()
    data object OnUnfocusSearchTextField : WorkSearchIntent()
    data class InputSearchText(val text: String) : WorkSearchIntent()
    data object ClickClearSearchText : WorkSearchIntent()
    data class ClickSearch(val searchTitle: String) : WorkSearchIntent()
    data class ClickListItem(val listItem: WorkEntity): WorkSearchIntent()
}
