package com.languagexx.newsApi.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.RequestManager
import com.languagexx.newsApi.R
import com.languagexx.newsApi.models.News
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_main.*
import timber.log.Timber
import javax.inject.Inject

class MainFragment:DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var newsAdapter: NewsAdapter

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    lateinit var newsViewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newsViewModel = ViewModelProviders.of(this, viewModelFactory).get(NewsViewModel::class.java)
        newsViewModel.loadNews()
        observeNews()
        return inflater.inflate(R.layout.fragment_main,container,false)
    }


    fun observeNews() {
        newsViewModel.observeNews().removeObservers(viewLifecycleOwner)
        newsViewModel.observeNews().observe(viewLifecycleOwner, object : Observer<List<News>> {
            override fun onChanged(t: List<News>?) {
                recyclerView.layoutManager = linearLayoutManager
                if (t!=null) {
                    newsAdapter.reset(t)
                }
                recyclerView.adapter = newsAdapter
                progress.visibility = View.GONE
            }
        })
    }

}