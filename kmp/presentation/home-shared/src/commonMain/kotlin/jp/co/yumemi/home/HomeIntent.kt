package jp.co.yumemi.home

import jp.co.yumemi.domain.entities.WorkEntity
import tech.fika.macaron.core.contract.Intent

sealed class HomeIntent : Intent {
    data object OnStart: HomeIntent()
    data class ClickListItem(val listItem: WorkEntity): HomeIntent()
}
