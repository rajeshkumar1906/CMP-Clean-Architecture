package com.rajesh.cmpcleanarchitecture.data.dto.news

import com.rajesh.cmpcleanarchitecture.domain.model.NewsData

fun NewsDto.toDomain(): List<NewsData> {
    return results.map { it.toDomain() }
}

fun Result.toDomain(): NewsData {
    return NewsData(
        title = title,
        description = description,
        url = link,
        urlToImage = imageUrl,
        publishedAt = pubDate,
        content = content
    )
}
