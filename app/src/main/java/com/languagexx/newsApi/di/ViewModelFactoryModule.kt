package com.languagexx.newsApi.di

import androidx.lifecycle.ViewModelProvider
import com.languagexx.newsApi.viewmodels.ViewModelFactory
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}