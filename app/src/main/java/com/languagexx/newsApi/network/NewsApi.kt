package com.languagexx.newsApi.network

import com.languagexx.newsApi.models.data
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/top-headlines")
    fun getNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ):Flowable<data>
}