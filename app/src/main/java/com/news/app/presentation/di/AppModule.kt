package com.news.app.presentation.di

import android.content.Context
import com.news.app.presentation.di.home.NewsListSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [NewsListSubComponent::class])
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideAppContext(): Context = context.applicationContext
}