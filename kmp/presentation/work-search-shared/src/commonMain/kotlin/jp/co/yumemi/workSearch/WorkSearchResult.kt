package jp.co.yumemi.workSearch

import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.domain.entities.WorkEntity
import tech.fika.macaron.core.contract.Result

sealed class WorkSearchResult : Result {
    data object Loading : WorkSearchResult()

    data class GetWorkSearchSuccess(
        val searchText: String,
        val workSearchList: List<WorkEntity>
    ) : WorkSearchResult()

    data class GetWorkSearchError(
        val searchText: String,
        val error: DomainError
    ) : WorkSearchResult()
}
