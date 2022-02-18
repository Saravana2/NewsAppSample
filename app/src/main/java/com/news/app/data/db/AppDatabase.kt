package com.news.app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.news.app.data.model.news.NewsListData

@Database(
    entities = [NewsListData::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun newsListDao(): NewsListDao
}