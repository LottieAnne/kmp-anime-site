package jp.co.yumemi.workDetails

import jp.co.yumemi.domain.entities.WorkEntity
import tech.fika.macaron.core.contract.Intent

sealed class WorkDetailsIntent : Intent {
    data object OnStart: WorkDetailsIntent()
}
