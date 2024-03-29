package jp.co.yumemi.tutorial

import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import tech.fika.macaron.core.contract.Event

sealed class TutorialEvent : Event, Parcelable {
    @Parcelize
    data object NavigateList : TutorialEvent()
}
