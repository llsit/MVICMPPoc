package com.roastkoff.mvicmppoc

import android.app.Application
import com.roastkoff.mvicmppoc.news.di.initKoin

class NewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}