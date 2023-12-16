package com.example.news.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.news.R
import com.example.news.databinding.ActivityHomeBinding
import com.example.news.ui.Constants
import com.example.news.ui.news.NewsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
   private lateinit var viewBinding: ActivityHomeBinding
   private lateinit var newsFragment : NewsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        getParam()
        newsFragment = NewsFragment.getInstance(getParam())
        startNewsFragment()
        viewBinding.appbarTxt.text = getParam()
    }

    private fun startNewsFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, newsFragment )
            .commit()
    }

   private fun getParam():String?{
        return intent.getStringExtra(Constants.CATEGORY_NAME)
    }
}