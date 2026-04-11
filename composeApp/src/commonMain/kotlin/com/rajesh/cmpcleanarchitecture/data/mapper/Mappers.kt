package com.rajesh.cmpcleanarchitecture.data.mapper

import com.rajesh.cmpcleanarchitecture.data.dto.ProductDto
import com.rajesh.cmpcleanarchitecture.domain.model.Product

fun ProductDto.toDomain(): Product {
    return Product(
        id = id,
        title = title,
        price = price,
        description = description,
        category = category,
        image = image
    )
}
