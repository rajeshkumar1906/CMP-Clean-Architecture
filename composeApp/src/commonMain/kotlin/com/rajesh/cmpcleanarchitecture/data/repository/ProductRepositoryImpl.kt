package com.rajesh.cmpcleanarchitecture.data.repository

import com.rajesh.cmpcleanarchitecture.data.dto.ProductDto
import com.rajesh.cmpcleanarchitecture.data.mapper.toDomain
import com.rajesh.cmpcleanarchitecture.domain.model.Product
import com.rajesh.cmpcleanarchitecture.domain.repository.ProductRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductRepositoryImpl(private val httpClient: HttpClient) : ProductRepository {
    override fun getProducts(): Flow<List<Product>> = flow {
        val response = httpClient.get("https://fakestoreapi.com/products").body<List<ProductDto>>()
        emit(response.map { it.toDomain() })
    }
}
