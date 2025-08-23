package com.example.navigation

interface Navigator {
    fun navigate(route: String)
    fun pop()
}