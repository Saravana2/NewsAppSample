package com.news.app.data.model.news

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "news_header")
data class NewsListData(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("urlToImage")
    var urlToImage: String? = null,
    @SerializedName("url")
    var url: String? = null
)