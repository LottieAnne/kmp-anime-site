package jp.co.yumemi.remote.apis

import jp.co.yumemi.remote.core.clients.ApiClient
import jp.co.yumemi.remote.core.infrastructure.HttpResponse
import jp.co.yumemi.remote.core.infrastructure.RequestConfig
import jp.co.yumemi.remote.core.infrastructure.RequestMethod
import jp.co.yumemi.remote.core.infrastructure.wrap
import jp.co.yumemi.remote.models.HomeApiModel

interface HomeApi {
    suspend fun getHomeWorkList(id: Int): HttpResponse<HomeApiModel>
}

class HomeApiImpl(
    private val apiClient: ApiClient
) : HomeApi {
    override suspend fun getHomeWorkList(id: Int): HttpResponse<HomeApiModel> {
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
