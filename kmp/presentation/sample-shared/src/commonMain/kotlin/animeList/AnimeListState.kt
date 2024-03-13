package jp.co.yumemi.animeList

import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.domain.entities.AnimeListItemEntity
import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import tech.fika.macaron.core.contract.State

sealed class AnimeListState : State, Parcelable {
    /** 初期状態 */
    @Parcelize
    data object Initial : AnimeListState()

    /** 初回ローディング */
    @Parcelize
    data object Loading : AnimeListState()

    /** 通常 */
    sealed class Stable : AnimeListState() {
        abstract val animeList: List<AnimeListItemEntity>

        /** 画面 */
        @Parcelize
        data class Initial(
            override val animeList: List<AnimeListItemEntity>,
        ) : Stable()
    }

    /** 初回ローディングエラー */
    @Parcelize
    data class Error(
        val error: DomainError
    ) : AnimeListState()
}
