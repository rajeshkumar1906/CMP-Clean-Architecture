package com.rajesh.cmpcleanarchitecture.data.network.api

import com.rajesh.cmpcleanarchitecture.data.dto.news.NewsDto
import com.rajesh.cmpcleanarchitecture.data.network.AppService
import com.rajesh.cmpcleanarchitecture.data.network.EndPoint
import com.rajesh.cmpcleanarchitecture.data.network.EnvironmentConfig
import com.rajesh.cmpcleanarchitecture.data.network.NetworkClient
import com.rajesh.cmpcleanarchitecture.domain.logger.Logger

class NewsApi(
    private val networkClient: NetworkClient,
    private val endpointConfig: EnvironmentConfig,
    private val logger: Logger
) {

    suspend fun getNews(): NewsDto {
        val client:NewsDto = networkClient.get(
            AppService.NEWS_INFO,
            endpointConfig.endPoint(EndPoint.NEWS_INFO),
            mapOf(
                "apikey" to "pub_8f8d0fe0880747c085a68ac8c1b6ece3",
                "q" to "technology"
            )
        )
        logger.debug("client info $client")
        return client
    }

}