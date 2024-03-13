package jp.co.yumemi.domain.entities

import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize

/**
 * アニメ一覧画面のアイテム
 */
@Parcelize
data class AnimeListItemEntity(
    /** 作品のイメージ画像 */
    val image: Int?,
    /** 作品のタイトル */
    val title: String,
    /** 作品のリリース時期 */
    val seasonName: String,
) : Parcelable
