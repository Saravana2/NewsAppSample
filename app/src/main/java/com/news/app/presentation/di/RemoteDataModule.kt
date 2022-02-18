package com.news.app.presentation.di

import com.news.app.data.api.NewsAPIService
import com.news.app.data.repository.datasource.NewsListRemoteDataSource
import com.news.app.data.repository.datasourceimpl.NewsListRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {

    @Singleton
    @Provides
    fun provideNewsListRemoteDataSource(newsAPIService: NewsAPIService): NewsListRemoteDataSource {
        return NewsListRemoteDataSourceImpl(newsAPIService,apiKey)
    }

}