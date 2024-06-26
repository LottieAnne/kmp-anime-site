package jp.co.yumemi.domain.entities

import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize

/**
 * 作品エピソード詳細
 */
@Parcelize
data class WorkEpisodeEntity(
    /** エピソードの話数 */
    val episodeNumber: String,
    /** エピソードタイトル */
    val episodeTitle: String,
) : Parcelable
