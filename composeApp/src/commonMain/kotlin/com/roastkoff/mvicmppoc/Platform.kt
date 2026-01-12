package com.roastkoff.mvicmppoc

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform