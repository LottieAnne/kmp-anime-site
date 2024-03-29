package jp.co.yumemi.tutorial

import tech.fika.macaron.core.contract.Action

sealed class TutorialAction: Action {
    data object NavigateList: TutorialAction()
}
