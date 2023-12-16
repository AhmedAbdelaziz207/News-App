package com.example.news.repository.NewsRepository

import com.example.news.data.api.newsModel.News

interface NewsRepository {
    suspend fun getNews(sourceId:String):List<News?>?
}