package com.languagexx.newsApi.di.main

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.RequestManager
import com.languagexx.newsApi.models.News
import com.languagexx.newsApi.network.NewsApi
import com.languagexx.newsApi.ui.main.MainActivity
import com.languagexx.newsApi.ui.main.NewsAdapter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MainModule {

    @Provides
    fun providesNewsApi(retrofit: Retrofit):NewsApi{
        return retrofit.create(NewsApi::class.java)
    }

    @Provides
    fun providesNewsAdapter(requestManager: RequestManager):NewsAdapter{
        return NewsAdapter(requestManager)
    }

    @Provides
    fun provideLayoutManager(application: Application):LinearLayoutManager{
        return LinearLayoutManager(application)
    }


}