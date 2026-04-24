package com.rajesh.cmpcleanarchitecture.domain.repository

import com.rajesh.cmpcleanarchitecture.domain.handlers.DataError
import com.rajesh.cmpcleanarchitecture.domain.model.NewsData
import com.rajesh.cmpcleanarchitecture.domain.handlers.Result
import com.rajesh.cmpcleanarchitecture.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
   suspend fun getNews(): Flow<Result<List<NewsData>, DataError.Remote>>
}
