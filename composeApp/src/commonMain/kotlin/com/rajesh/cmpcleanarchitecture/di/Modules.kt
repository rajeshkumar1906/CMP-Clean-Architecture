package com.rajesh.cmpcleanarchitecture.di

import com.rajesh.cmpcleanarchitecture.data.network.AppEnvironment
import com.rajesh.cmpcleanarchitecture.data.network.AppService
import com.rajesh.cmpcleanarchitecture.data.network.EndPoint
import com.rajesh.cmpcleanarchitecture.data.network.EnvironmentConfig
import com.rajesh.cmpcleanarchitecture.data.network.NetworkClient
import com.rajesh.cmpcleanarchitecture.data.network.api.NewsApi
import com.rajesh.cmpcleanarchitecture.data.repository.NewsRepositoryImpl
import com.rajesh.cmpcleanarchitecture.domain.logger.Logger
import com.rajesh.cmpcleanarchitecture.domain.repository.NewsRepository
import com.rajesh.cmpcleanarchitecture.domain.usecase.GetProductsUseCase
import com.rajesh.cmpcleanarchitecture.presentation.screen.ProductViewModel
import com.rajesh.cmpcleanarchitecture.presentation.screen.news.NewsViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    coerceInputValues = true
                })
            }
            install(Logging) {
                level = LogLevel.ALL
                logger = object : io.ktor.client.plugins.logging.Logger {
                    override fun log(message: String) {
                        println("KTOR: $message")
                    }
                }
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 30000
                connectTimeoutMillis = 30000
                socketTimeoutMillis = 30000
            }
        }
    }

    single<Logger> {
        object : Logger {
            override fun debug(message: String) = println("DEBUG: $message")
            override fun info(message: String) = println("INFO: $message")
            override fun warn(message: String) = println("WARN: $message")
            override fun error(message: String, throwable: Throwable) {
                println("ERROR: $message")
                throwable.printStackTrace()
            }
        }
    }

    single<EnvironmentConfig> {
        object : EnvironmentConfig {
            override val appEnvironment: AppEnvironment = AppEnvironment.DEV
            override fun baseUrl(service: AppService): String = "https://newsdata.io"
            override fun endPoint(service: EndPoint): String = "/api/1/latest"
        }
    }

    singleOf(::NetworkClient)
    singleOf(::NewsApi)
    singleOf(::NewsRepositoryImpl) { bind<NewsRepository>() }
}

val domainModule = module {
    factoryOf(::GetProductsUseCase)
}

val viewModelModule = module {
    viewModelOf(::ProductViewModel)
    viewModelOf(::NewsViewModel)
}

fun appModule() = listOf(dataModule, domainModule, viewModelModule)
