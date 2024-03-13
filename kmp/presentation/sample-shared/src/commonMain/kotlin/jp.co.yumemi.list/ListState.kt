package jp.co.yumemi.list

import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.domain.entities.ListCardEntity
import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import tech.fika.macaron.core.contract.State

sealed class ListState : State, Parcelable {
    /** 初期状態 */
    @Parcelize
    data object Initial : ListState()

    /** 初回ローディング */
    @Parcelize
    data object Loading : ListState()

    /** 通常 */
    sealed class Stable : ListState() {
        abstract val list: List<ListCardEntity>

        /** 画面 */
        @Parcelize
        data class Initial(
            override val list: List<ListCardEntity>,
        ) : Stable()
    }

    /** 初回ローディングエラー */
    @Parcelize
    data class Error(
        val error: DomainError
    ) : ListState()
}
