package com.krishpan.abcnews.repository

import ArticleDatabase
import com.krishpan.abcnews.api.RetrofitInstance
import com.krishpan.abcnews.models.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getHeadLines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getFavouriteNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)


}