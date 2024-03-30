package jp.co.yumemi.tutorial

import tech.fika.macaron.core.contract.Intent

sealed class TutorialIntent: Intent {
    data object ClickStart : TutorialIntent()
}
