package com.news.app.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.news.app.data.model.news.NewsListData
import com.news.app.databinding.ItemNewsHeadlinesBinding
import com.news.app.presentation.utils.loadImage

class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.NewsListViewHolder>() {

    private val newsList = ArrayList<NewsListData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder =
        NewsListViewHolder(
            ItemNewsHeadlinesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) =
        holder.bind(newsList[position])

    override fun getItemCount() = newsList.size

    fun setNewsList(list: List<NewsListData>) {
        newsList.clear()
        newsList.addAll(list)
    }

    class NewsListViewHolder(private val binding: ItemNewsHeadlinesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: NewsListData) {
            binding.titleTv.text = news.title
            binding.descTv.text = news.description
            binding.newsImageView.loadImage(news.urlToImage)
        }
    }
}