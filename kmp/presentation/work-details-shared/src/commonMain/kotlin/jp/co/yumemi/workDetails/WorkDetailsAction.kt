package jp.co.yumemi.workDetails

import tech.fika.macaron.core.contract.Action

sealed class WorkDetailsAction : Action {
    data object GetWorkDetailsList : WorkDetailsAction()
}
