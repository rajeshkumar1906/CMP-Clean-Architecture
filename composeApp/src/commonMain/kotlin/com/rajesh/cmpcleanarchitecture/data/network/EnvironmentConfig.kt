package com.rajesh.cmpcleanarchitecture.data.network


enum class AppEnvironment{
    DEV,STAGING,PROD
}
interface EnvironmentConfig{
    val appEnvironment: AppEnvironment
    fun baseUrl(service: AppService): String
    fun endPoint(service: EndPoint): String
}