package com.rajesh.cmpcleanarchitecture.data.dto.news


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsDto(
    @SerialName("nextPage")
    val nextPage: String? = null,
    @SerialName("results")
    val results: List<Result>? = null,
    @SerialName("status")
    val status: String? = null,
    @SerialName("totalResults")
    val totalResults: Int? = null
)