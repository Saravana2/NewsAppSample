package com.news.app.presentation

import android.app.Application
import com.news.app.data.api.NewsAPIService
import com.news.app.presentation.di.*
import com.news.app.presentation.di.home.NewsListSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().apply {
            appModule(AppModule(applicationContext))
            netModule(NetModule(NewsAPIService.BASE_URL))
            remoteDataModule(RemoteDataModule("f408c205b84d40b19e54cfcc040dcd9a"))
        }.also {
            appComponent = it.build()
        }
    }

    override fun createNewsListSubComponent(): NewsListSubComponent {
        return appComponent.newsListSubComponent().create()
    }
}