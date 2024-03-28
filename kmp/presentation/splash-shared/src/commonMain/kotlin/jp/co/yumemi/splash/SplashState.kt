package jp.co.yumemi.splash

import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import tech.fika.macaron.core.contract.State

sealed class SplashState: State, Parcelable {
    @Parcelize
    data object Stable : SplashState()
}
