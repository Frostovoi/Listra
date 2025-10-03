package com.example.api.models

data class Page<T>(
    val items: List<T>,
    val nextPage: Int?,
    val total: Int? = null
)
