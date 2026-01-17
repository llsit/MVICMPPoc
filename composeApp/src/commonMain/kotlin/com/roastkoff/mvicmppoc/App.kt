package com.roastkoff.mvicmppoc

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.roastkoff.mvicmppoc.home.HomeScreen
import com.roastkoff.mvicmppoc.home.HomeViewModel
import com.roastkoff.mvicmppoc.news.data.NewsRepository
import com.roastkoff.mvicmppoc.news.data.NewsRepositoryImpl
import com.roastkoff.mvicmppoc.news.screen.NewsScreen
import com.roastkoff.mvicmppoc.news.viewmodel.NewsViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
//        val viewModel = HomeViewModel()
//        HomeScreen(viewModel)
        NewsScreen()
    }
}