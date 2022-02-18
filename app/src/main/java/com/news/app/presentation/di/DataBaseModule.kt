package com.news.app.presentation.di

import android.content.Context
import androidx.room.Room
import com.news.app.data.db.AppDatabase
import com.news.app.data.db.NewsListDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideDataBase(context: Context): AppDatabase
        = Room.databaseBuilder(context, AppDatabase::class.java,"news_app").build()

    @Singleton
    @Provides
    fun provideNewsListDao(appDatabase: AppDatabase): NewsListDao = appDatabase.newsListDao()
}