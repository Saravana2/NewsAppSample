package com.news.app.data.repository

import android.util.Log
import com.news.app.data.model.news.NewsListData
import com.news.app.data.repository.datasource.NewsListLocalDataSource
import com.news.app.data.repository.datasource.NewsListRemoteDataSource
import com.news.app.domain.repository.NewsListRepository

class NewsListRepositoryImpl(
    private val newsListRemoteDataSource: NewsListRemoteDataSource,
    private val newsListLocalDataSource: NewsListLocalDataSource
) : NewsListRepository {

    override suspend fun getNews(): List<NewsListData> =
        getNewsFromDB()

    override suspend fun updateNews(): List<NewsListData> {
        newsListLocalDataSource.clearAll()
        return getNews()
    }

    private suspend fun getNewsFromRemote(): List<NewsListData> {
        var list: List<NewsListData> = listOf()
        try {
            val response = newsListRemoteDataSource.getNewsList()
            val body = response.body()
            if (body != null) {
                list = body.articles ?: listOf()
            }
        } catch (e: Exception) {
            Log.i("Remote:Get News ", e.message.toString())
        }
        return list
    }

    private suspend fun getNewsFromDB(): List<NewsListData> {
        lateinit var list: List<NewsListData>
        try {
            list = newsListLocalDataSource.getNews()
        } catch (e: Exception) {
            Log.i("DB:Get News", e.message.toString())
        }
        if (list.isEmpty()) {
            list = getNewsFromRemote()
            newsListLocalDataSource.saveNews(list)
        }
        return list
    }
}