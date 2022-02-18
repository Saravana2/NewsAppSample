package com.news.app.presentation.di

import com.news.app.data.db.NewsListDao
import com.news.app.data.repository.datasource.NewsListLocalDataSource
import com.news.app.data.repository.datasourceimpl.NewsListLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(newsListDao: NewsListDao): NewsListLocalDataSource {
        return NewsListLocalDataSourceImpl(newsListDao)
    }

}