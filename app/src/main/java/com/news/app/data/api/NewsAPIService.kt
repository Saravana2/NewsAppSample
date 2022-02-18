package com.news.app.data.api

import com.news.app.data.model.news.NewsListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {

    companion object {
        const val BASE_URL = "https://newsapi.org/"
        private const val SUB_PATH = "v2"
    }

    @GET("$SUB_PATH/top-headlines")
    suspend fun getTopHeadlines(
        @Query("apiKey") apiKey: String,
        @Query("sources") sources: String = "google-news-in"
    ): Response<NewsListResponse>

}