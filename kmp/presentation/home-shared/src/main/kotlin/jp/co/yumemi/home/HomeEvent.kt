package jp.co.yumemi.home

import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import tech.fika.macaron.core.contract.Event

sealed class HomeEvent : Event, Parcelable {
    @Parcelize
    data class NavigateDetails(val listItem: WorkEntity): HomeEvent()
}
