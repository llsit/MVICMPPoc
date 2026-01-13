package com.roastkoff.mvicmppoc.news.intent

sealed interface NewsIntent {
    object LoadNews : NewsIntent
    object Refresh : NewsIntent
    data class ClickNews(val newsId: String) : NewsIntent
}