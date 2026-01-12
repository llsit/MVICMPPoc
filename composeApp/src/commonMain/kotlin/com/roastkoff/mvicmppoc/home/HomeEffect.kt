package com.roastkoff.mvicmppoc.home

sealed interface HomeEffect {
    data class ShowToast(val message: String) : HomeEffect
}