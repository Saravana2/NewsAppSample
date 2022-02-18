package com.news.app.presentation.di

import com.news.app.domain.repository.NewsListRepository
import com.news.app.domain.usecase.GetNewsUseCase
import com.news.app.domain.usecase.UpdateNewsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetNewsUseCase(repository: NewsListRepository) = GetNewsUseCase(repository)

    @Provides
    fun provideUpdateNewsUseCase(repository: NewsListRepository) = UpdateNewsUseCase(repository)

}