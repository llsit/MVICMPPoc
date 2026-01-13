package com.roastkoff.mvicmppoc.news.data

import kotlinx.coroutines.delay

interface NewsRepository {
    suspend fun fetchTopNews(): List<Article>
}

class NewsRepositoryImpl : NewsRepository {
    override suspend fun fetchTopNews(): List<Article> {
        delay(1000)
        return listOf(
            Article(
                title = "Compose Multiplatform is growing",
                description = "JetBrains continues to improve CMP",
                imageUrl = null,
                url = "https://example.com"
            ),
            Article(
                title = "Samsung Galaxy S26 Ultra Release Dates, Pre-Order Offers And Pricing",
                description = "Update, Monday Jan. 12: This article has been updated with details on both the pricing and the in-store availability of the Galaxy S26, Galaxy S26+ and Galaxy S26 Ultra",
                imageUrl = null,
                url = "https://example.com"
            ),
            Article(
                title = "This Smart Tea Cup Wants You to Actually Enjoy Your Tea",
                description = "Here’s something you probably haven’t thought about today: when was the last time you actually paid attention while drinking tea?",
                imageUrl = null,
                url = "https://example.com"
            )
        )
    }
}