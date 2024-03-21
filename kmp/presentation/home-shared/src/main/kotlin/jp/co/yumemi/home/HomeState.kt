package jp.co.yumemi.home

import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.domain.entities.HomeEntity
import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import kotlinx.parcelize.RawValue
import tech.fika.macaron.core.contract.State

sealed class HomeState : State, Parcelable {
    @Parcelize
    data object Initial : HomeState()

    @Parcelize
    data object Loading : HomeState()

    @Parcelize
    data class Stable(
        val homeList: List<HomeEntity>,
    ) : HomeState()

    @Parcelize
    data class Error(
        val error: DomainError
    ): HomeState()
}
