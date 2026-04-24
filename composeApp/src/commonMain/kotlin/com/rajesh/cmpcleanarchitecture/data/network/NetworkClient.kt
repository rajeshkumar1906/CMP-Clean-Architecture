package com.rajesh.cmpcleanarchitecture.data.network

import com.rajesh.cmpcleanarchitecture.domain.logger.Logger
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

class NetworkClient(
    val client: HttpClient,
    val environmentConfig: EnvironmentConfig,
    val logger: Logger
) {

    val json: Json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        encodeDefaults = false
    }

    suspend inline fun <reified T> get(
        serviceUrl: AppService,
        path: String,
        queryParams: Map<String, String> = emptyMap(),
    ): T {
        val url = environmentConfig.baseUrl(serviceUrl) + path
        return client.get(url) {
            queryParams.forEach { (k, v) ->
                parameter(k, v)
            }
        }.body<T>()
    }
}
