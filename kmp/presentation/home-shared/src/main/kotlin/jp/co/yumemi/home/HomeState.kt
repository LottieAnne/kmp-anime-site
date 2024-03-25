package jp.co.yumemi.home

import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import tech.fika.macaron.core.contract.State

sealed class HomeState : State, Parcelable {
    @Parcelize
    data object Initial : HomeState()

    @Parcelize
    data object Loading : HomeState()

    @Parcelize
    data class Stable(
        val homeList: List<WorkEntity>,
    ) : HomeState()

    @Parcelize
    data class Error(
        val error: DomainError
    ): HomeState()
}
