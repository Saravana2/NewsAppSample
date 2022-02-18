package com.news.app.domain.usecase

import com.news.app.domain.repository.NewsListRepository

class UpdateNewsUseCase(private val repository: NewsListRepository) {
    suspend fun execute() = repository.updateNews()
}