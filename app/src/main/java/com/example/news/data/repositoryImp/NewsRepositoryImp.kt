package com.example.news.data.repositoryImp

import com.example.news.data.api.newsModel.News
import com.example.news.data.dataSourceImp.NewsDataSourceImp
import com.example.news.repository.NewsRepository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImp @Inject constructor(private val newsOnlineDataSource: NewsDataSourceImp):NewsRepository {
    override suspend fun getNews(sourceId: String): List<News?>? {
        return newsOnlineDataSource.getNews(sourceId)
    }
}