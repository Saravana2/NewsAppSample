package com.news.app.presentation.di.home

import com.news.app.presentation.home.NewsListViewModelFactory
import dagger.Subcomponent

@NewsListScope
@Subcomponent(modules = [NewsListModule::class])
interface NewsListSubComponent {

    fun getNewsListViewModelFactory() : NewsListViewModelFactory

    @Subcomponent.Factory
    interface Factory{
        fun create():NewsListSubComponent
    }
}