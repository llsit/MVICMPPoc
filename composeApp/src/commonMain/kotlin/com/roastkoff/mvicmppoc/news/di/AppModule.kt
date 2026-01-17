package com.roastkoff.mvicmppoc.news.di

import com.roastkoff.mvicmppoc.news.data.NewsRepository
import com.roastkoff.mvicmppoc.news.data.NewsRepositoryImpl
import com.roastkoff.mvicmppoc.news.service.GNewsApi
import com.roastkoff.mvicmppoc.news.service.GNewsApiImpl
import com.roastkoff.mvicmppoc.news.service.HttpClientFactory
import com.roastkoff.mvicmppoc.news.viewmodel.NewsViewModel
import org.koin.dsl.module

val appModule = module {
    // Repository
    single<NewsRepository> { NewsRepositoryImpl(get()) }

    // ViewModel
    factory { NewsViewModel(get()) }
}

val networkModule = module {
    single { HttpClientFactory.create() }

    single<GNewsApi> { GNewsApiImpl(get()) }
}
