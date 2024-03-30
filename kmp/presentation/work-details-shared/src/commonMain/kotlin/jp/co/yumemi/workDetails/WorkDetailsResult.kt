package jp.co.yumemi.workDetails

import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.domain.entities.WorkDetailsEntity
import jp.co.yumemi.domain.entities.WorkEpisodeEntity
import tech.fika.macaron.core.contract.Result

sealed class WorkDetailsResult: Result {
    data object Loading : WorkDetailsResult()
    data class GetWorkDetailsListSuccess(val workDetailsList: List<WorkDetailsEntity>) : WorkDetailsResult()
    data class GetWorkEpisodeListSuccess(val workEpisodeList: List<WorkEpisodeEntity>) : WorkDetailsResult()
    data class GetWorkDetailsListError(val error: DomainError) : WorkDetailsResult()
    data class GetWorkEpisodesListError(val error: DomainError) : WorkDetailsResult()
}
