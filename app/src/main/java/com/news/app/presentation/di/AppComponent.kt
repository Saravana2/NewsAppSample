package com.news.app.presentation.di

import com.news.app.presentation.di.home.NewsListSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DataBaseModule::class,
        NetModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {
    fun newsListSubComponent(): NewsListSubComponent.Factory
}