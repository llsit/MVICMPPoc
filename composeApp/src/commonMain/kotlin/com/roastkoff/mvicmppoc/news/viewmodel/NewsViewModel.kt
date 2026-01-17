package com.roastkoff.mvicmppoc.news.viewmodel

import androidx.lifecycle.ViewModel
import com.roastkoff.mvicmppoc.common.AppLogger
import com.roastkoff.mvicmppoc.news.data.NewsRepository
import com.roastkoff.mvicmppoc.news.effect.NewsEffect
import com.roastkoff.mvicmppoc.news.intent.NewsIntent
import com.roastkoff.mvicmppoc.news.state.NewsState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewsViewModel(
    private val repository: NewsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(NewsState())
    val state: StateFlow<NewsState> = _state

    private val _effect = Channel<NewsEffect>()
    val effect = _effect.receiveAsFlow()

    init {
        onIntent(NewsIntent.LoadNews)
    }

    fun onIntent(intent: NewsIntent) {
        when (intent) {
            NewsIntent.LoadNews -> loadNews()
            NewsIntent.Refresh -> loadNews()
            is NewsIntent.ClickNews -> {}
        }
    }

    private fun loadNews() {
        CoroutineScope(Dispatchers.Default).launch {
            _state.update { it.copy(isLoading = true) }
            AppLogger.d("loadNews", "loadNews: -> isLoading")
            runCatching {
                repository.fetchTopHeadlines()
            }.onSuccess { news ->
                AppLogger.d("loadNews", "loadNews: Success -> $news")
                _state.update {
                    it.copy(
                        isLoading = false,
                        news = news
                    )
                }
            }.onFailure {
                AppLogger.d("loadNews", "loadNews: Error -> ${it.message}")
                _state.update { it.copy(isLoading = false) }
                _effect.send(
                    NewsEffect.ShowMessage("Failed to load news")
                )
            }
        }
    }
}
