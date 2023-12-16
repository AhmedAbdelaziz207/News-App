package com.example.news.data.dataSourceImp

import com.example.news.data.api.WebServices
import com.example.news.data.api.newsModel.News
import com.example.news.dataSource.NewsDataSource
import javax.inject.Inject

class NewsDataSourceImp @Inject constructor(private val webServices: WebServices): NewsDataSource {
    override suspend fun getNews(sourceId:String): List<News?>? {
       return webServices.getNews(sources = sourceId).articles
    }
}