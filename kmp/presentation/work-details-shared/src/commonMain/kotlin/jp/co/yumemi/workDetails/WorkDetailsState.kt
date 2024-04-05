package jp.co.yumemi.workDetails

import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.domain.entities.WorkEpisodeEntity
import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import tech.fika.macaron.core.contract.State

sealed class WorkDetailsState : State, Parcelable {
    abstract val work: WorkEntity

    @Parcelize
    data class Initial(override val work: WorkEntity) : WorkDetailsState()

    @Parcelize
    data class Loading(override val work: WorkEntity) : WorkDetailsState()

    @Parcelize
    data class Stable(
        override val work: WorkEntity,
        val workEpisodeList: List<WorkEpisodeEntity>,
    ) : WorkDetailsState()

    @Parcelize
    data class Error(
        override val work: WorkEntity,
        val error: DomainError
    ) : WorkDetailsState()
}
