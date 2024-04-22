package jp.co.yumemi.workSearch

import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import tech.fika.macaron.core.contract.State

sealed class WorkSearchState : State, Parcelable {
    @Parcelize
    data object Initial : WorkSearchState()

    @Parcelize
    data object Loading : WorkSearchState()

    @Parcelize
    data class Stable(
        val searchText: String,
        val searchWork: List<WorkEntity>,
    ) : WorkSearchState()

    @Parcelize
    data class Error(
        val searchText: String,
        val error: DomainError
    ) : WorkSearchState()
}
