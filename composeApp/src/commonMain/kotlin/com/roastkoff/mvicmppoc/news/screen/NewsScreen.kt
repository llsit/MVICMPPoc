package com.roastkoff.mvicmppoc.news.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.roastkoff.mvicmppoc.news.data.Article
import com.roastkoff.mvicmppoc.news.effect.NewsEffect
import com.roastkoff.mvicmppoc.news.viewmodel.NewsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NewsScreen(
    viewModel: NewsViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is NewsEffect.ShowMessage ->
                    snackbarHostState.showSnackbar(effect.message)
            }
        }
    }
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when {
                state.isLoading -> {
                    Text("Loading...")
                }

                state.error != null -> {
                    Text(state.error!!)
                }

                else -> {
                    LazyColumn {
                        itemsIndexed(state.articles) { index, article ->
                            NewsItem(article, index + 1)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NewsItem(article: Article, index: Int) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "$index ${article.title}",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = article.description,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}