package com.roastkoff.mvicmppoc.news.state

import com.roastkoff.mvicmppoc.news.data.News

data class NewsState(
    val isLoading: Boolean = false,
    val news: List<News> = emptyList(),
    val error: String? = null
)
