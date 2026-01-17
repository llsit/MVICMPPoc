package com.roastkoff.mvicmppoc.news.service

import com.roastkoff.mvicmppoc.news.data.NewsRepositoryImpl.Companion.API_KEY
import com.roastkoff.mvicmppoc.news.data.ResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

interface GNewsApi {
    suspend fun topHeadlines(
        category: String = "general",
        lang: String = "en",
        max: Int = 10
    ): ResponseDto
}

class GNewsApiImpl(
    private val client: HttpClient
) : GNewsApi {

    override suspend fun topHeadlines(
        category: String,
        lang: String,
        max: Int
    ): ResponseDto {
        try {
            val response = client.get("top-headlines") {
                parameter("category", category)
                parameter("lang", lang)
                parameter("max", max)
                parameter("apikey", API_KEY)
            }.body<ResponseDto>()
            return response
        } catch (e: Exception) {
            throw e
        }
    }
}