package com.news.app.data.repository.datasource

import com.news.app.data.model.news.NewsListResponse
import retrofit2.Response

interface NewsListRemoteDataSource {
    suspend fun getNewsList(): Response<NewsListResponse>
}