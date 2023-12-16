package com.example.news.ui.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.data.api.newsModel.News
import com.example.news.data.api.sourcesModel.Source
import com.example.news.repository.NewsRepository.NewsRepository
import com.example.news.repository.sourceRepository.SourceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepositoryImp: NewsRepository,
    private val sourceRepositoryImp: SourceRepository
) : ViewModel(){

    var shouldShowLoading = MutableLiveData<Boolean>()
    var sourcesLiveData = MutableLiveData<List<Source?>?>()
    var newsLiveData = MutableLiveData<List<News?>?>()
    var viewErrorLiveData = MutableLiveData<ViewsError>()


     fun getNewsSources(category:String) {
        shouldShowLoading.value = true

         viewModelScope.launch {

             try {
                  val sources = sourceRepositoryImp.getSources(category)
                  sourcesLiveData.postValue(sources)

             }catch (ex:HttpException){

                 viewErrorLiveData.postValue(
                            ViewsError(message = ex.message)
                 )

             }catch (ex:Exception){
                 viewErrorLiveData .postValue(
                       ViewsError(throwable = ex)
                 )

             }finally {
                 shouldShowLoading.value = false
             }


         }




   }
     fun getNews(sourceId: String?) {
         shouldShowLoading.value = true
         viewModelScope.launch {
             try {
                 val articles = newsRepositoryImp.getNews(sourceId!!)

                 newsLiveData.postValue(articles)
             } catch (ex: HttpException) {
                 viewErrorLiveData.postValue(
                     ViewsError(message = ex.message)
                 )
             } catch (ex: Exception) {
                 viewErrorLiveData.postValue(
                     ViewsError(throwable = ex)
                 )
             } finally {
                 shouldShowLoading.value = false
             }

         }


     }


}