package com.news.app.data.repository.datasource

import com.news.app.data.model.news.NewsListData

interface NewsListLocalDataSource {
    suspend fun clearAll()
    suspend fun saveNews(items: List<NewsListData>)
    suspend fun getNews(): List<NewsListData>
}