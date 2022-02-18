package com.news.app.presentation.di.home

import com.news.app.domain.usecase.GetNewsUseCase
import com.news.app.domain.usecase.UpdateNewsUseCase
import com.news.app.presentation.home.NewsListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class NewsListModule {

    @NewsListScope
    @Provides
    fun provideNewsListViewModelFactory(
        getNewsUseCase: GetNewsUseCase,
        updateNewsUseCase: UpdateNewsUseCase
    ) =
        NewsListViewModelFactory(getNewsUseCase, updateNewsUseCase)

}