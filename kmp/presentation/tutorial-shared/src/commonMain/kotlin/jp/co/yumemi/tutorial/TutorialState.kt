package jp.co.yumemi.tutorial

import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import tech.fika.macaron.core.contract.State

sealed class TutorialState: State, Parcelable {
    @Parcelize
    data object Stable: TutorialState()
}
