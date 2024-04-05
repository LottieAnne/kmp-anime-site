package jp.co.yumemi.workDetails

import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.domain.entities.WorkEpisodeEntity
import tech.fika.macaron.core.contract.Result

sealed class WorkDetailsResult : Result {
    data object Loading : WorkDetailsResult()

    data class GetWorkDetailsSuccess(
        val workEpisodeList: List<WorkEpisodeEntity>
    ) : WorkDetailsResult()

    data class GetWorkDetailsError(val error: DomainError) : WorkDetailsResult()
}
