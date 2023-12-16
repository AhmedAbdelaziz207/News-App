package com.example.news.ui.news

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.news.data.api.newsModel.News
import com.example.news.data.api.sourcesModel.Source
import com.example.news.databinding.FragmentNewsBinding
import com.example.news.ui.Constants
import com.example.news.ui.newsDetails.NewsDetailsActivity
import com.example.news.ui.showDialog
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class NewsFragment : Fragment() {
    private lateinit var viewBinding : FragmentNewsBinding
    private lateinit var viewModel: NewsViewModel
    var categoryName : String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentNewsBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
        viewModel.getNewsSources(categoryName!!)
    }

    private fun initObservers() {
//        viewModel.shouldShowLoading.observe(viewLifecycleOwner)
//        {
////                   isShow -> viewBinding.progressBar.isVisible = isShow!!
//        }

        viewModel.sourcesLiveData.observe(viewLifecycleOwner){sources->
            bindDataOnTabs(sources)
        }
        viewModel.newsLiveData.observe(viewLifecycleOwner){articles->
            adapter.bindData(articles)
        }

        viewModel.viewErrorLiveData.observe(
            viewLifecycleOwner
        ){
            handleError(it)
        }
    }


    private fun bindDataOnTabs(sources: List<Source?>?) {
        if( sources == null )
            return

        sources.forEach {source ->
            val tab = viewBinding.tabLayout.newTab()
            tab.text = source?.name
            tab.tag = source
            viewBinding.tabLayout.addTab(tab)

        }
        viewBinding.tabLayout.addOnTabSelectedListener(
          object :  TabLayout.OnTabSelectedListener{
              override fun onTabSelected(tab: TabLayout.Tab?) {
                  val source = tab?.tag as Source
                  viewModel.getNews(source.id)
              }

              override fun onTabReselected(tab: TabLayout.Tab?) {
                  val source = tab?.tag as Source
                  viewModel.getNews(source.id)
              }

              override fun onTabUnselected(tab: TabLayout.Tab?) {
                 return
              }
            }
        )
        viewBinding.tabLayout.getTabAt(0)?.select()

    }

    private val adapter = NewsAdapter(null)

    private fun initViews() {
        viewBinding.vm = viewModel
        viewBinding.lifecycleOwner = this
        viewBinding.recyclerView.adapter = adapter

        adapter.onArticleClickListener = NewsAdapter.OnArticleClickListener{ position, article ->
            openNewsDetailsActivity(article)
        }
    }

    private fun openNewsDetailsActivity(article: News) {
        val intent = Intent(context , NewsDetailsActivity::class.java)
        intent.putExtra(Constants.ARTICLE, article)
        startActivity(intent)
    }


    private fun handleError(viewsError: ViewsError){
        viewBinding.progressBar.isVisible = false
        showDialog(viewsError.throwable?.message?:viewsError.message?: "something went wrong",
            posMessage = "try again",
            posAction  = {
                    dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            , negMessage = "Cansel"
            , negAction = { dialog, _ ->
                dialog.dismiss()

            }

        )
    }

    companion object {
        fun getInstance(categoryName : String?): NewsFragment {
          var instance =   NewsFragment()
            instance.categoryName = categoryName
            return instance
        }
    }


}
