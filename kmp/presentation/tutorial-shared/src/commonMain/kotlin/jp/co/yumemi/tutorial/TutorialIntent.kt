package jp.co.yumemi.tutorial

import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import tech.fika.macaron.core.contract.Intent

sealed class TutorialIntent: Intent, Parcelable {
    @Parcelize
    data object ClickStart : TutorialIntent()
}
