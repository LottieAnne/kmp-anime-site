package jp.co.yumemi.splash

import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import tech.fika.macaron.core.contract.Event

sealed class SplashEvent : Event, Parcelable {
    @Parcelize
    data object NavigateTutorial : SplashEvent()
    @Parcelize
    data object NavigateWorkList : SplashEvent()
}
