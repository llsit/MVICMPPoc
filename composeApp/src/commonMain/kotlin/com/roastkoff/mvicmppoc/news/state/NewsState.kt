package com.roastkoff.mvicmppoc.news.state

import com.roastkoff.mvicmppoc.news.data.Article

data class NewsState(
    val isLoading: Boolean = false,
    val articles: List<Article> = emptyList(),
    val error: String? = null
)
