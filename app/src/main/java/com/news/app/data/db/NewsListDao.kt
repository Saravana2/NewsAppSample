package com.news.app.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.news.app.data.model.news.NewsListData

@Dao
interface NewsListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNews(list: List<NewsListData>)

    @Query("DELETE FROM news_header")
    suspend fun clear()

    @Query("SELECT * FROM news_header")
    suspend fun getAll() : List<NewsListData>

}