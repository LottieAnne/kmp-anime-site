package jp.co.yumemi.splash

import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import tech.fika.macaron.core.contract.State

/**
 * スプラッシュ画面 State
 */
sealed class SplashState : State, Parcelable {
    @Parcelize
    data object Initial : SplashState()

    @Parcelize
    data class Error(
        val error: DomainError
    ) : SplashState()
}
