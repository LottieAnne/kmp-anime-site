package jp.co.yumemi.remote.apis

import jp.co.yumemi.remote.core.clients.ApiClient
import jp.co.yumemi.remote.core.infrastructure.HttpResponse
import jp.co.yumemi.remote.core.infrastructure.RequestConfig
import jp.co.yumemi.remote.core.infrastructure.RequestMethod
import jp.co.yumemi.remote.core.infrastructure.wrap
import jp.co.yumemi.remote.models.WorkInfoResponseApiModel


interface WorkInfoApi {
    suspend fun getWorkInfo(): HttpResponse<WorkInfoResponseApiModel>
}

class WorkInfoApiImpl(
    private val apiClient: ApiClient
) : WorkInfoApi {
    override suspend fun getWorkInfo(): HttpResponse<WorkInfoResponseApiModel> {
        val headers = mutableMapOf<String, String>()
        val requestConfig = RequestConfig<Any?>(
            method = RequestMethod.GET,
            path = "/v1/works",
            headers = headers,
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
