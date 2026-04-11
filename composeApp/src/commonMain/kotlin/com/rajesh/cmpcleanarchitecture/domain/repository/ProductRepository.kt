package com.rajesh.cmpcleanarchitecture.domain.repository

import com.rajesh.cmpcleanarchitecture.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProducts(): Flow<List<Product>>
}
