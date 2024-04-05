package jp.co.yumemi.workDetails

import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.domain.entities.WorkEpisodeEntity
import jp.co.yumemi.domain.entities.WorkInfoEntity
import tech.fika.macaron.core.contract.Result

sealed class WorkDetailsResult : Result {
    data object Loading : WorkDetailsResult()
    data class GetWorkInfoSuccess(val workInfo: WorkInfoEntity) : WorkDetailsResult()
    data class GetWorkInfoError(val error: DomainError) : WorkDetailsResult()
    data class GetWorkEpisodeListSuccess(val workEpisodeList: List<WorkEpisodeEntity>) : WorkDetailsResult()
    data class GetWorkEpisodeListError(val error: DomainError) : WorkDetailsResult()
}
