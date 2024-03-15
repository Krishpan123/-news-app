package com.krishpan.abcnews.models

import com.krishpan.abcnews.models.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)