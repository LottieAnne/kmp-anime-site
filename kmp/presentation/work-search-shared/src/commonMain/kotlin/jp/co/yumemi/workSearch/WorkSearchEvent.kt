package jp.co.yumemi.workSearch

import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import tech.fika.macaron.core.contract.Event

sealed class WorkSearchEvent : Event, Parcelable {
    @Parcelize
    data object NavigateBack: WorkSearchEvent()

    @Parcelize
    data class NavigateDetails(val listItem: WorkEntity) : WorkSearchEvent()
}
