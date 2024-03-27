package jp.co.yumemi.home

import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.domain.entities.WorkEntity
import tech.fika.macaron.core.contract.Result

sealed class HomeResult : Result {
    data object Loading : HomeResult()
    data class GetWorkListSuccess(val workList: List<WorkEntity>) : HomeResult()
    data class GetWorkListError(val error: DomainError) : HomeResult()
}
