package com.news.app.domain.repository

import com.news.app.data.model.news.NewsListData

interface NewsListRepository {
    suspend fun getNews() : List<NewsListData>
    suspend fun updateNews() : List<NewsListData>
}