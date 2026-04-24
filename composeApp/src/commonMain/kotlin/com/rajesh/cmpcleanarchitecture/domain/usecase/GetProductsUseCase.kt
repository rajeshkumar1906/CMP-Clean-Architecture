package com.rajesh.cmpcleanarchitecture.domain.usecase

import com.rajesh.cmpcleanarchitecture.domain.handlers.DataError
import com.rajesh.cmpcleanarchitecture.domain.handlers.Result
import com.rajesh.cmpcleanarchitecture.domain.model.NewsData
import com.rajesh.cmpcleanarchitecture.domain.model.Product
import com.rajesh.cmpcleanarchitecture.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(private val repository: NewsRepository) {
    suspend operator fun invoke(): Flow<Result<List<NewsData>, DataError.Remote>> {
        return repository.getNews()
    }
}
