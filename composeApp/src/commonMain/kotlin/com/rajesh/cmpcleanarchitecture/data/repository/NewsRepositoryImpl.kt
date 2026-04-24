package com.rajesh.cmpcleanarchitecture.data.repository

import com.rajesh.cmpcleanarchitecture.data.dto.news.NewsDto
import com.rajesh.cmpcleanarchitecture.data.dto.news.toDomain
import com.rajesh.cmpcleanarchitecture.data.network.AppService
import com.rajesh.cmpcleanarchitecture.data.network.EndPoint
import com.rajesh.cmpcleanarchitecture.data.network.api.NewsApi
import com.rajesh.cmpcleanarchitecture.domain.handlers.DataError
import com.rajesh.cmpcleanarchitecture.domain.handlers.Result
import com.rajesh.cmpcleanarchitecture.domain.model.NewsData
import com.rajesh.cmpcleanarchitecture.domain.repository.NewsRepository
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepositoryImpl(
    private val api: NewsApi
) : NewsRepository {
    override suspend fun getNews(): Flow<Result<List<NewsData>, DataError.Remote>>{
      return try {
          flow {
              val response = api.getNews().toDomain()
              emit(Result.Success(response))
          }
      } catch (exception: Exception) {
          flow { emit(Result.Error(DataError.Remote.STATUS_ERROR)) }
      }





    }
}
