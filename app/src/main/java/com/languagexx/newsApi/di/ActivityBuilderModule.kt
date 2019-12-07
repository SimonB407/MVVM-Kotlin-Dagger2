package com.languagexx.newsApi.di

import com.languagexx.newsApi.di.main.MainFragmentBuilderModule
import com.languagexx.newsApi.di.main.MainModule
import com.languagexx.newsApi.di.main.MainViewModelModule
import com.languagexx.newsApi.ui.main.MainActivity
import com.languagexx.newsApi.ui.main.NewsAdapter
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainViewModelModule::class,MainModule::class,MainFragmentBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity

}