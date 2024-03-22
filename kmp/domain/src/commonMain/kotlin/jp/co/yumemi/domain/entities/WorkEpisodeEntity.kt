package jp.co.yumemi.domain.entities

import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize

/**
 * 作品エピソード詳細
 */
@Parcelize
data class WorkEpisodeEntity(
    /** エピソード数 */
    val episodeNumber: Int,
    /** エピソードタイトル */
    val episodeTitle: String,
) : Parcelable
