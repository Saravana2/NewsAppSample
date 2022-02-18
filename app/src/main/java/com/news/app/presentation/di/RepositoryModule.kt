package com.news.app.presentation.di

import com.news.app.data.repository.NewsListRepositoryImpl
import com.news.app.data.repository.datasource.NewsListLocalDataSource
import com.news.app.data.repository.datasource.NewsListRemoteDataSource
import com.news.app.domain.repository.NewsListRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideNewsRepository(
        newsListRemoteDataSource: NewsListRemoteDataSource,
        newsListLocalDataSource: NewsListLocalDataSource
    ): NewsListRepository {
        return NewsListRepositoryImpl(
            newsListRemoteDataSource,
            newsListLocalDataSource
        )
    }
}