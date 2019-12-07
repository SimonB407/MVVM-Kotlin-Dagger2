package com.languagexx.newsApi.ui.main

import androidx.lifecycle.*
import com.languagexx.newsApi.models.News
import com.languagexx.newsApi.models.data
import com.languagexx.newsApi.network.NewsApi
import com.languagexx.newsApi.util.Constants
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.function.Function
import javax.inject.Inject

class NewsViewModel @Inject constructor(newsApi: NewsApi) : ViewModel() {

    var newsApi: NewsApi
    var mediatorLiveData: MediatorLiveData<List<News>> = MediatorLiveData()
    var newsList = mutableListOf<News>()

    fun loadNews() {
        val source: LiveData<data> = LiveDataReactiveStreams.fromPublisher(
            newsApi.getNews(Constants.COUNTRY, "general", Constants.API_KEY)
                .subscribeOn(Schedulers.io()))


        mediatorLiveData.addSource(source, object : Observer<data> {
            override fun onChanged(t: data?) {
                Timber.e(t?.articles?.get(0)?.urlToImage)
                for (i in t?.articles!!) {
                    val news = News(i.source.name,i.author,i.title,i.content,i.urlToImage)
                    Timber.e(news.urlToImage)
                    newsList.add(news)

                }
                mediatorLiveData.value = newsList
                mediatorLiveData.removeSource(source)

            }
        })
    }

    fun observeNews(): LiveData<List<News>> {
        return mediatorLiveData
    }

    init {
        this.newsApi = newsApi
    }
}