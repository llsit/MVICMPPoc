package com.roastkoff.mvicmppoc.news.service

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import kotlin.js.json

actual object HttpClientFactory {
    actual fun create(): HttpClient {
        return HttpClient(Js) {
            install(ContentNegotiation) {
                json()
            }
        }
    }
}