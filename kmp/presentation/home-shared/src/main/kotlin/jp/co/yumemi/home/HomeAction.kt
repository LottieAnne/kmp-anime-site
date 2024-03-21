package jp.co.yumemi.home

import tech.fika.macaron.core.contract.Action

sealed class HomeAction : Action {
    data object GetHomeWorkList : HomeAction()
}
