package com.roastkoff.mvicmppoc.news.effect

sealed interface NewsEffect {
    data class ShowMessage(val message: String) : NewsEffect
}