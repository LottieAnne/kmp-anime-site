package jp.co.yumemi.workDetails

import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.domain.entities.WorkEpisodeEntity
import jp.co.yumemi.domain.entities.WorkInfoEntity
import tech.fika.macaron.core.contract.Result

sealed class WorkDetailsResult : Result {
    data object Loading : WorkDetailsResult()

    data class GetWorkDetailsSuccess(
        val workInfo: WorkInfoEntity,
        val workEpisodeList: List<WorkEpisodeEntity>
    ) : WorkDetailsResult()

    data class GetWorkDetailsError(val error: DomainError) : WorkDetailsResult()
}
