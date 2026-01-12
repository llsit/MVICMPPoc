package com.roastkoff.mvicmppoc.home

data class HomeState(
    val isLoading: Boolean = false,
    val items: List<String> = emptyList(),
    val error: String? = null
)