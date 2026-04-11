package com.rajesh.cmpcleanarchitecture.domain.usecase

import com.rajesh.cmpcleanarchitecture.domain.model.Product
import com.rajesh.cmpcleanarchitecture.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(private val repository: ProductRepository) {
    operator fun invoke(): Flow<List<Product>> {
        return repository.getProducts()
    }
}
