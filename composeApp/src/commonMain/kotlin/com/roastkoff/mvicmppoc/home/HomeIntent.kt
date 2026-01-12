package com.roastkoff.mvicmppoc.home

// Intent (สิ่งที่ user ทำ)
sealed interface HomeIntent {
    object LoadData : HomeIntent
    data class ClickItem(val id: String) : HomeIntent
}