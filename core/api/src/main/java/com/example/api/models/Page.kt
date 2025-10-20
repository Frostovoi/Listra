package com.example.api.models

data class Page<T>(
    val items: List<T>,
    val page: Int,
    val pageSize: Int,
    val total: Int
)
