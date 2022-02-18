package com.news.app.presentation.di

import com.news.app.presentation.di.home.NewsListSubComponent

interface Injector {
    fun createNewsListSubComponent() : NewsListSubComponent
}