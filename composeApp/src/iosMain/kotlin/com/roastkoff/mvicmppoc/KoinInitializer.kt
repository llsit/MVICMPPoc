package com.roastkoff.mvicmppoc

import com.roastkoff.mvicmppoc.news.di.appModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(appModule)
    }
}