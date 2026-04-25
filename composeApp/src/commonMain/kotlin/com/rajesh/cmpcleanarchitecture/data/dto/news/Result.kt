package com.rajesh.cmpcleanarchitecture.data.dto.news


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
//    @SerialName("ai_org")
//    val aiOrg: String = "",
//    @SerialName("ai_region")
//    val aiRegion: String = "",
//    @SerialName("ai_summary")
//    val aiSummary: String = "",
//    @SerialName("ai_tag")
//    val aiTag: String = "",
//    @SerialName("article_id")
//    val articleId: String = "",
//    @SerialName("category")
//    val category: List<String>? = listOf(),
//    @SerialName("content")
//    val content: String = "",
//    @SerialName("country")
//    val country: List<String>? = listOf(),
//    @SerialName("creator")
//    val creator: List<String>? = listOf(),
//    @SerialName("datatype")
//    val datatype: String = "",
//
//    @SerialName("duplicate")
//    val duplicate: Boolean = false,
//    @SerialName("fetched_at")
//    val fetchedAt: String = "",
//    @SerialName("image_url")
//    val imageUrl: String? = null,
//    @SerialName("keywords")
//    val keywords: List<String>? = listOf(),
//    @SerialName("language")
//    val language: String = "",
//    @SerialName("link")
//    val link: String = "",
//    @SerialName("pubDate")
//    val pubDate: String = "",
//    @SerialName("pubDateTZ")
//    val pubDateTZ: String = "",
//    @SerialName("sentiment")
//    val sentiment: String = "",
//    @SerialName("sentiment_stats")
//    val sentimentStats: String = "",
//    @SerialName("source_icon")
//    val sourceIcon: String? = null,
//    @SerialName("source_id")
//    val sourceId: String = "",
//    @SerialName("source_name")
//    val sourceName: String = "",
//    @SerialName("source_priority")
//    val sourcePriority: Int = 0,
//    @SerialName("source_url")
//    val sourceUrl: String = "",
    @SerialName("title")
    val title: String? = null,
    @SerialName("description")
    val description: String? = null,
//    @SerialName("video_url")
//    val videoUrl: String? = null
)