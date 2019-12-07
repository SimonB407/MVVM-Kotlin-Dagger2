package com.languagexx.newsApi.di.main

import androidx.lifecycle.ViewModel
import com.languagexx.newsApi.di.ViewModelKey
import com.languagexx.newsApi.ui.main.NewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    abstract fun bindNewsViewModel(newsViewModel: NewsViewModel): ViewModel

}