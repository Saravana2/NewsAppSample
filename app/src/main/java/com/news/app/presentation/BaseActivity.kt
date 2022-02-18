package com.news.app.presentation

import androidx.appcompat.app.AppCompatActivity
import com.news.app.presentation.di.Injector

open class BaseActivity : AppCompatActivity() {
    fun getAppInjector() = application as Injector
}