package jp.co.yumemi.domain.entities

import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize

/**
 * ホーム画面 一覧のアイテム
 */
@Parcelize
data class WorkEntity(
    /** 作品のタイトル */
    val title: String,
    /** 作品のリリース時期 */
    val seasonName: String,
    /** 作品のイメージ画像 */
    val imageUrl: String?,
) : Parcelable
