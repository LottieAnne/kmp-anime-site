package jp.co.yumemi.remote.apis

import jp.co.yumemi.remote.core.clients.ApiClient
import jp.co.yumemi.remote.core.infrastructure.HttpResponse
import jp.co.yumemi.remote.core.infrastructure.RequestConfig
import jp.co.yumemi.remote.core.infrastructure.RequestMethod
import jp.co.yumemi.remote.core.infrastructure.wrap
import jp.co.yumemi.remote.models.WorkListResponseApiModel


interface WorkSearchListApi {
    suspend fun getSearchWorkList(title: String): HttpResponse<WorkListResponseApiModel>
}

class WorkSearchListApiImpl(
    private val apiClient: ApiClient
) : WorkSearchListApi {
    override suspend fun getSearchWorkList(title: String): HttpResponse<WorkListResponseApiModel> {
        val headers = mutableMapOf<String, String>()
        val requestConfig = RequestConfig<Any?>(
            method = RequestMethod.GET,
            path = "/v1/works",
            headers = headers,
            query = mutableMapOf("filter_title" to listOf(title)),
            body = null
        )
        val authNames = listOf("access_token")
        return apiClient.jsonRequest(
            authNames = authNames,
            requestConfig = requestConfig,
            body = null,
        ).wrap()
    }
}
