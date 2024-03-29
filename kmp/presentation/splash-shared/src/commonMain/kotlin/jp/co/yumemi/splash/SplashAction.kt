package jp.co.yumemi.splash

import tech.fika.macaron.core.contract.Action

sealed class SplashAction : Action {
    data object CheckFirstUse : SplashAction()
}
