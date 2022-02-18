package com.news.app.domain.usecase

import com.news.app.domain.repository.NewsListRepository

class GetNewsUseCase(
    private val newsListRepository: NewsListRepository
) {
    suspend fun execute() = newsListRepository.getNews()
}