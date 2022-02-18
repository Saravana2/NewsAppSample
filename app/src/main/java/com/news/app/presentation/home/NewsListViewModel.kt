package com.news.app.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.news.app.data.model.news.NewsListData
import com.news.app.domain.usecase.GetNewsUseCase
import com.news.app.domain.usecase.UpdateNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsListViewModel(
    private val getNewsUseCase: GetNewsUseCase,
    private val updateNewsUseCase: UpdateNewsUseCase
) : ViewModel() {

    private val _itemList = MutableLiveData<List<NewsListData>>()
    val itemList: LiveData<List<NewsListData>>
        get() = _itemList

    fun getTopHeadlines() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = getNewsUseCase.execute()
            _itemList.postValue(list)
        }
    }

    fun getLatestTopHeadlines() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = updateNewsUseCase.execute()
            _itemList.postValue(list)
        }
    }

}