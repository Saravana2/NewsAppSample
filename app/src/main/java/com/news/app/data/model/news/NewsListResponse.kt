package com.news.app.data.model.news

import com.google.gson.annotations.SerializedName

data class NewsListResponse(
    @SerializedName("status")
    var status: String? = null,
    @SerializedName("totalResults")
    var totalResults: Int? = null,
    @SerializedName("articles")
    var articles: List<NewsListData>? = null,
)