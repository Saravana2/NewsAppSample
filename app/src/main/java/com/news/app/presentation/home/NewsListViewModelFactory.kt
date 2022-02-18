package com.news.app.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.news.app.domain.usecase.GetNewsUseCase
import com.news.app.domain.usecase.UpdateNewsUseCase

class NewsListViewModelFactory(
    private val getNewsUseCase: GetNewsUseCase,
    private val updateNewsUseCase: UpdateNewsUseCase
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsListViewModel(getNewsUseCase,updateNewsUseCase) as T
    }
}