package com.rajesh.cmpcleanarchitecture.data.network.api

import com.rajesh.cmpcleanarchitecture.data.dto.news.NewsDto
import com.rajesh.cmpcleanarchitecture.data.network.AppService
import com.rajesh.cmpcleanarchitecture.data.network.EndPoint
import com.rajesh.cmpcleanarchitecture.data.network.EnvironmentConfig
import com.rajesh.cmpcleanarchitecture.data.network.NetworkClient

class NewsApi(
    private val networkClient: NetworkClient,
    private val endpointConfig: EnvironmentConfig
) {

    suspend fun getNews(): NewsDto{
        return networkClient.get(AppService.NEWS_INFO, endpointConfig.endPoint(EndPoint.NEWS_INFO))
    }

}