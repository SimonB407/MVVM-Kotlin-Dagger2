package com.languagexx.newsApi.di

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.languagexx.newsApi.BaseApplication
import com.languagexx.newsApi.R
import com.languagexx.newsApi.util.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesRequestOptions():RequestOptions{
        return RequestOptions()
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
    }

    @Singleton
    @Provides
    fun provideRequestManager(application: Application,requestOptions: RequestOptions):RequestManager{
        return Glide.with(application)
            .applyDefaultRequestOptions(requestOptions)
    }
}