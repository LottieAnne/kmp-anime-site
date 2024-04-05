package jp.co.yumemi.workDetails

import jp.co.yumemi.domain.entities.WorkEntity
import tech.fika.macaron.core.contract.Action

sealed class WorkDetailsAction : Action {
    data object GetWorkInfo : WorkDetailsAction()
    data object GetWorkEpisodeList: WorkDetailsAction()
}
