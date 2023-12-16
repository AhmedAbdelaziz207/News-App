package com.example.news.repository.sourceRepository

import com.example.news.data.api.sourcesModel.Source

interface SourceRepository {
    suspend fun getSources(category: String):List<Source?>?
}