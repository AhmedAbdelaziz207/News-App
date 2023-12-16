package com.example.news.dataSource

import com.example.news.data.api.sourcesModel.Source

interface SourcesDataSource {
    suspend fun getSources(category: String):List<Source?>?
}