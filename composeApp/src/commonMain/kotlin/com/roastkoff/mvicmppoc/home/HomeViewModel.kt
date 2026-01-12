package com.roastkoff.mvicmppoc.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state

    private val _effect = MutableSharedFlow<HomeEffect>()
    val effect = _effect.asSharedFlow()

    init {
        onIntent(HomeIntent.LoadData)
    }

    fun onIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.LoadData -> loadData()
            is HomeIntent.ClickItem -> onItemClick(intent.id)
        }
    }

    private fun loadData() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            delay(1_000)
            // mock data
            _state.update {
                it.copy(
                    isLoading = false,
                    items = listOf("Apple", "Banana", "Orange")
                )
            }

            _effect.emit(
                HomeEffect.ShowToast("Load Success")
            )
        }

    }

    private fun onItemClick(id: String) {
        viewModelScope.launch {
            _effect.emit(
                HomeEffect.ShowToast("Clicked $id")
            )
        }
    }
}
