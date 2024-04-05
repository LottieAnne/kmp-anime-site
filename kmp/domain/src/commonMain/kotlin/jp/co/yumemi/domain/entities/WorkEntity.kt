package jp.co.yumemi.domain.entities

import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize

/**
 * ホーム画面 一覧/詳細のアイテム
 */
@Parcelize
data class WorkEntity(
    /** 作品のid */
    val id: Int,
    /** 作品のタイトル */
    val title: String,
    /** 作品のリリース時期 */
    val seasonName: String,
    /** 作品のイメージ画像 */
    val imageUrl: String?,
    /** エピソード数 */
    val episodes: Int,
    /** 見てる / 見たい / 見た人の数 */
    val watchers: Int,
    /** レビュー数 */
    val reviews: Int,
) : Parcelable
