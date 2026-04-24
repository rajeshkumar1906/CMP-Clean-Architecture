package com.rajesh.cmpcleanarchitecture.data.dto.news


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsDto(
    @SerialName("nextPage")
    val nextPage: String = "",
    @SerialName("results")
    val results: List<Result> = listOf(),
    @SerialName("status")
    val status: String = "",
    @SerialName("totalResults")
    val totalResults: Int = 0
)