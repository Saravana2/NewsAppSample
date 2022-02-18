package com.news.app.presentation.home

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.news.app.databinding.ActivityNewsBinding
import com.news.app.presentation.BaseActivity

class NewsListActivity : BaseActivity() {

    private lateinit var binding: ActivityNewsBinding
    private lateinit var viewModel: NewsListViewModel
    private lateinit var newsAdapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val factory = getAppInjector().createNewsListSubComponent().getNewsListViewModelFactory()
        viewModel = ViewModelProvider(this, factory)[NewsListViewModel::class.java]

        initNewsRecyclerView()
        setClickActions()
        setUpObserver()
        getNews()
    }

    private fun setClickActions() {
        binding.reloadFab.apply {
            setOnClickListener {
                changeLoadingVisibility(false)
                viewModel.getLatestTopHeadlines()
            }
        }
    }

    private fun setUpObserver() {
        viewModel.itemList.observe(this) {
            newsAdapter.setNewsList(it)
            newsAdapter.notifyDataSetChanged()
            changeLoadingVisibility(true)
        }
    }

    private fun getNews() {
        changeLoadingVisibility(false)
        viewModel.getTopHeadlines()
    }

    private fun initNewsRecyclerView() {
        newsAdapter = NewsListAdapter()
        binding.newsRecyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = newsAdapter
        }
    }

    private fun changeLoadingVisibility(visible: Boolean) {
        binding.newsRecyclerView.isVisible = visible
        binding.progressBar.isVisible = !visible
    }

}