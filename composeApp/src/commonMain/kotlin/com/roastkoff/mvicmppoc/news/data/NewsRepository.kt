package com.roastkoff.mvicmppoc.news.data

import com.roastkoff.mvicmppoc.common.AppLogger
import com.roastkoff.mvicmppoc.news.service.GNewsApi
import kotlinx.coroutines.delay

interface NewsRepository {
    suspend fun fetchFakeNews(): List<Article>
    suspend fun fetchTopNews(
        category: String = "general",
        lang: String = "en",
        max: Int = 10
    ): List<News>
}

class NewsRepositoryImpl(
    private val api: GNewsApi
) : NewsRepository {
    companion object {
        const val BASE_URL = "https://gnews.io/api/v4"
        const val API_KEY = "a936d7b4f91544f20c96891a7cd32c96"
    }

    override suspend fun fetchFakeNews(): List<Article> {
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

    override suspend fun fetchTopNews(
        category: String,
        lang: String,
        max: Int
    ): List<News> {
        AppLogger.d("NewsRepository", "fetchTopHeadlines: Starting")
        return api.topHeadlines(
            category = category,
            lang = lang,
            max = max
        ).articles.map {
            AppLogger.d("NewsRepository", "fetchTopNews: $it")
            News(
                title = it.title,
                description = it.description.orEmpty(),
                imageUrl = it.image,
                source = it.source.name
            )
        }
    }

}