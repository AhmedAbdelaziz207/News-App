package com.example.news.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.news.data.api.newsModel.News
import com.example.news.databinding.ItemNewsBinding

class NewsAdapter(private var articlesList: List<News?>?) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = articlesList?.get(position)

        holder.viewBinding.news = article
        holder.viewBinding.invalidateAll()

       holder.viewBinding.article.setOnClickListener{
            onArticleClickListener.onClick(position, article!!)
        }

        }

    override fun getItemCount(): Int {
      return  articlesList?.size?:0
    }

    fun bindData(articles: List<News?>?) {
        articlesList = articles
        notifyDataSetChanged()
    }
     lateinit var onArticleClickListener: OnArticleClickListener
    fun interface OnArticleClickListener{
        fun onClick(position:Int , article:News)
    }


    class NewsViewHolder(var viewBinding: ItemNewsBinding):ViewHolder(viewBinding.root)
}