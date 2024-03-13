package jp.co.yumemi.animeListDetail

import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.domain.entities.AnimeEpisodeEntity
import jp.co.yumemi.domain.entities.AnimeListDetailEntity
import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import tech.fika.macaron.core.contract.State

sealed class AnimeListDetailState : State, Parcelable {
    /** 初期状態 */
    @Parcelize
    data object Initial : AnimeListDetailState()

    /** 初回ローディング */
    @Parcelize
    data object Loading : AnimeListDetailState()

    /** 通常 */
    sealed class Stable : AnimeListDetailState() {
        abstract val animeListDetail: AnimeListDetailEntity
        abstract val animeEpisodeDetail: List<AnimeEpisodeEntity>

        /** 画面 */
        @Parcelize
        data class Initial(
            override val animeListDetail: AnimeListDetailEntity,
            override val animeEpisodeDetail: List<AnimeEpisodeEntity>,
        ) : Stable()
    }

    /** 初回ローディングエラー */
    @Parcelize
    data class Error(
        val error: DomainError
    ) : AnimeListDetailState()
}
