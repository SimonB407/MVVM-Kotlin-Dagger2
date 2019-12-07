package com.languagexx.newsApi.di.main

import com.languagexx.newsApi.ui.main.DetailFragment
import com.languagexx.newsApi.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesMainFragment():MainFragment

    @ContributesAndroidInjector
    abstract fun contributesDetailFragment():DetailFragment
}