package jp.co.yumemi.workDetails

import jp.co.yumemi.domain.entities.WorkEntity
import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import tech.fika.macaron.core.contract.Event

sealed class WorkDetailsEvent : Event, Parcelable {}
