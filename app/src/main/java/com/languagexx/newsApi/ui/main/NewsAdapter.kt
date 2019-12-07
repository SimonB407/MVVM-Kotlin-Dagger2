package com.languagexx.newsApi.ui.main

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.TimePicker
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.languagexx.newsApi.R
import com.languagexx.newsApi.models.News
import timber.log.Timber
import javax.inject.Inject

class NewsAdapter @Inject constructor(requestManager: RequestManager): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    var requestManager:RequestManager
    var newsList: List<News> = ArrayList<News>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.txtTitle?.text = newsList.get(position).title
        holder.txtAuthor?.text = newsList.get(position).author
        holder.txtContent?.text = newsList.get(position).content
        holder.txtSource?.text = newsList.get(position).sourceName

        requestManager
            .asBitmap()
            .centerCrop()
            .load(newsList.get(position).urlToImage)
            .into(holder.imageView!!)
    }


    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitle: TextView? = null
        var txtContent: TextView? = null
        var txtAuthor: TextView? = null
        var txtSource: TextView? = null
        var imageView: ImageView? = null


        init {
            this.txtTitle = itemView.findViewById(R.id.textTitle)
            this.txtAuthor = itemView.findViewById(R.id.textAuthor)
            this.txtSource = itemView.findViewById(R.id.textSource)
            this.txtContent = itemView.findViewById(R.id.textContent)
            this.imageView = itemView.findViewById(R.id.imageView)
        }
    }

    fun reset(newsList:List<News>) {
        this.newsList = newsList
        notifyDataSetChanged()

    }

    init {
        this.requestManager = requestManager
    }

}