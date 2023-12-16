package com.example.news.data.api

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    fun provideLoggingInterceptor():HttpLoggingInterceptor{
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            Log.e("Api", it )
        })
    }

    @Provides
    fun provideOkkHttp(loggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    fun provideGsonFactory():GsonConverterFactory{
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideRetrofit(
        okkHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ):Retrofit{
        return Retrofit
            .Builder()
            .client(okkHttpClient)
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(gsonConverterFactory)
            .build()
    }
    @Provides
    fun provideWebservice(retrofit: Retrofit):WebServices{
        return retrofit.create(WebServices::class.java)
    }
}