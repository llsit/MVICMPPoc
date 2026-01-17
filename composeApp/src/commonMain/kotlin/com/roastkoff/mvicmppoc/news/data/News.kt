package com.roastkoff.mvicmppoc.news.data

data class News(
    val title: String,
    val description: String,
    val imageUrl: String?,
    val source: String
)