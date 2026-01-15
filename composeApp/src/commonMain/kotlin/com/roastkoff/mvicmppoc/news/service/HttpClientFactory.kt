package com.roastkoff.mvicmppoc.news.service

import io.ktor.client.HttpClient

expect object HttpClientFactory {
    fun create(): HttpClient
}