package com.news.app.data.repository.datasourceimpl

import com.news.app.data.db.NewsListDao
import com.news.app.data.model.news.NewsListData
import com.news.app.data.repository.datasource.NewsListLocalDataSource

class NewsListLocalDataSourceImpl(
    private val newsListDao: NewsListDao
) : NewsListLocalDataSource {
    override suspend fun clearAll() = newsListDao.clear()

    override suspend fun saveNews(items: List<NewsListData>) = newsListDao.saveNews(items)

    override suspend fun getNews(): List<NewsListData> = newsListDao.getAll()
}