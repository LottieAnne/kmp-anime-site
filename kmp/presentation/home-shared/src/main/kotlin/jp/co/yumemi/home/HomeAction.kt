package jp.co.yumemi.home

import jp.co.yumemi.domain.entities.WorkEntity
import tech.fika.macaron.core.contract.Action

sealed class HomeAction : Action {
    data object GetHomeWorkList : HomeAction()

    data class NavigateDetails(val listItem: WorkEntity): HomeAction()
}
