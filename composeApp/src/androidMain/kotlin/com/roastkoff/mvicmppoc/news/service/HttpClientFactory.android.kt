package com.roastkoff.mvicmppoc.news.service

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

actual object HttpClientFactory {
    actual fun create(): HttpClient {
        return HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json()
            }
        }
    }
}