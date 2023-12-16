package com.example.news.repository

import com.example.news.data.dataSourceImp.NewsDataSourceImp
import com.example.news.data.dataSourceImp.SourcesOnlineDataSourceImp
import com.example.news.data.repositoryImp.NewsRepositoryImp
import com.example.news.data.repositoryImp.SourceRepositoryImp
import com.example.news.dataSource.NewsDataSource
import com.example.news.dataSource.SourcesDataSource
import com.example.news.repository.NewsRepository.NewsRepository
import com.example.news.repository.sourceRepository.SourceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideSourcesRepository(
        sourcesRepository: SourceRepositoryImp
    ):SourceRepository

    @Binds
    abstract fun provideSourcesDataSource(
        sourcesDataSourceImp: SourcesOnlineDataSourceImp
    ):SourcesDataSource

    @Binds
    abstract fun provideNewsRepository(
        newsRepositoryImp: NewsRepositoryImp
    ):NewsRepository
    @Binds
    abstract fun provideNewsDataSource(
        newsDataSourceImp: NewsDataSourceImp
    ):NewsDataSource

}