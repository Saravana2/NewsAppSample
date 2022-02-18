package com.news.app.data.repository.datasourceimpl

import com.news.app.data.api.NewsAPIService
import com.news.app.data.model.news.NewsListResponse
import com.news.app.data.repository.datasource.NewsListRemoteDataSource
import retrofit2.Response

class NewsListRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,private val apiKey:String
) : NewsListRemoteDataSource {
    override suspend fun getNewsList(): Response<NewsListResponse> =
        newsAPIService.getTopHeadlines(apiKey)
}