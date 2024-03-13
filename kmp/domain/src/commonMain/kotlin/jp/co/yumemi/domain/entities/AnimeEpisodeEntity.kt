package jp.co.yumemi.domain.entities

import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize

/**
 * アニメエピソード詳細
 */
@Parcelize
data class AnimeEpisodeEntity(
    /** エピソード数 */
    val episodeNumber: Int,
    /** エピソードタイトル */
    val episodeTitle: String,
) : Parcelable

