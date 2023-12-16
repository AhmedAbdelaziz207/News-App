package com.example.news.data.repositoryImp

import com.example.news.data.api.sourcesModel.Source
import com.example.news.dataSource.SourcesDataSource
import com.example.news.repository.sourceRepository.SourceRepository
import javax.inject.Inject

class SourceRepositoryImp @Inject constructor(private val source: SourcesDataSource): SourceRepository {
    override suspend fun getSources(category:String): List<Source?>? {
       return source.getSources(category)
    }

}