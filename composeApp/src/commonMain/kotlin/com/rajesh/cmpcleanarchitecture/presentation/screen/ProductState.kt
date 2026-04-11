package com.rajesh.cmpcleanarchitecture.presentation.screen

import com.rajesh.cmpcleanarchitecture.domain.model.Product

data class ProductState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)
