package com.example.news.data.api

import com.example.news.data.api.newsModel.NewsResponse
import com.example.news.data.api.sourcesModel.SourcesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {
    @GET("v2/top-headlines/sources")
    suspend fun getSources(
        @Query("apiKey") apiKey : String = ApiConstants.apiKey,
        @Query("category") categoryName :String
    ): SourcesResponse

    @GET("v2/everything")
    suspend fun getNews(
        @Query("apiKey") apiKey : String = ApiConstants.apiKey,
        @Query("sources") sources : String,
    ): NewsResponse



    @GET("v2/everything")
    fun getNewsBySearch(
        @Query("apiKey") apiKey : String = ApiConstants.apiKey,
        @Query("q") q : String
    ):Call<NewsResponse>



}