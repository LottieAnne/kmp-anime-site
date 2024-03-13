package jp.co.yumemi.domain.entities

import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize

/**
 * アニメ詳細画面
 */
@Parcelize
data class AnimeListDetailEntity(
    /** 作品のタイトル */
    val animeTitle: String,
    /** 作品のリリース時期 */
    val seasonName: String,
    /** エピソード数 */
    val episodes: Int,
    /** 見てる / 見たい / 見た人の数 */
    val watchers: Int,
    /** レビュー数 */
    val reviews: Int,
) : Parcelable
