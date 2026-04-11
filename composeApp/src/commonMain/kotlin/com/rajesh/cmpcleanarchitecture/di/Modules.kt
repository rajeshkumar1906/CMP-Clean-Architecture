package com.rajesh.cmpcleanarchitecture.di

import com.rajesh.cmpcleanarchitecture.data.repository.ProductRepositoryImpl
import com.rajesh.cmpcleanarchitecture.domain.repository.ProductRepository
import com.rajesh.cmpcleanarchitecture.domain.usecase.GetProductsUseCase
import com.rajesh.cmpcleanarchitecture.presentation.screen.ProductViewModel
import io.ktor.client.HttpClient
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
                })
            }
            install(Logging) {
                level = LogLevel.ALL
            }
        }
    }
    singleOf(::ProductRepositoryImpl) { bind<ProductRepository>() }
}

val domainModule = module {
    factoryOf(::GetProductsUseCase)
}

val viewModelModule = module {
    viewModelOf(::ProductViewModel)
}

fun appModule() = listOf(dataModule, domainModule, viewModelModule)
