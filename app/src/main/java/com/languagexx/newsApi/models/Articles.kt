package com.languagexx.newsApi.models

data class Articles(
    val source:Source,
    val author:String,
    val title:String,
    val content:String,
    val urlToImage:String

)