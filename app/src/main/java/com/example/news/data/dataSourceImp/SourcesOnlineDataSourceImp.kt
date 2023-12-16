package com.example.news.data.dataSourceImp

import com.example.news.data.api.WebServices
import com.example.news.data.api.sourcesModel.Source
import com.example.news.dataSource.SourcesDataSource
import javax.inject.Inject

class SourcesOnlineDataSourceImp @Inject constructor(private val webServices: WebServices):SourcesDataSource {
    override suspend fun getSources(category: String): List<Source?>?{
        return webServices.getSources(categoryName = category).sources
    }

}