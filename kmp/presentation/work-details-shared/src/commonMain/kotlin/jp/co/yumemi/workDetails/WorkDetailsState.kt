package jp.co.yumemi.workDetails

import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.domain.entities.WorkEpisodeEntity
import jp.co.yumemi.domain.entities.WorkInfoEntity
import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import tech.fika.macaron.core.contract.State

sealed class WorkDetailsState : State, Parcelable {
    @Parcelize
    data object Initial : WorkDetailsState()

    @Parcelize
    data object Loading : WorkDetailsState()

    @Parcelize
    data class Stable(
        val workInfo: WorkInfoEntity,
        val workEpisodeList: List<WorkEpisodeEntity>,
    ) : WorkDetailsState()

    @Parcelize
    data class Error(
        val error: DomainError
    ) : WorkDetailsState()
}
