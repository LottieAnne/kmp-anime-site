package jp.co.yumemi.splash

import tech.fika.macaron.core.contract.Intent

sealed class SplashIntent : Intent {
    data object OnStart : SplashIntent()
}
