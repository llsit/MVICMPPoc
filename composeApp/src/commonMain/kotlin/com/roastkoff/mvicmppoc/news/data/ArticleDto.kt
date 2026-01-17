package com.roastkoff.mvicmppoc.news.data

import kotlinx.serialization.Serializable

@Serializable
data class ArticleDto(
    val title: String,
    val description: String? = null,
    val url: String,
    val image: String? = null,
    val publishedAt: String,
    val source: SourceDto
)

@Serializable
data class SourceDto(
    val name: String
)

@Serializable
data class ResponseDto(
    val totalArticles: Int,
    val articles: List<ArticleDto>
)