package com.example.news.ui.newsDetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.news.data.api.newsModel.News
import com.example.news.databinding.ActivityNewsDetailsBinding
import com.example.news.ui.Constants

class NewsDetailsActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivityNewsDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityNewsDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        getParameters()
        initViews()
    }

    private fun initViews() {
        bindImage(viewBinding.image, article?.urlToImage.toString())
        Log.e("Url",  article?.url.toString() )
        viewBinding.content.text = article?.description
        viewBinding.author.text = article?.source?.name
        viewBinding.title.text = article?.title
        viewBinding.viewArticle.setOnClickListener{
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(article?.url))
            startActivity(browserIntent)
        }

    }

    private var article:News? = null
    fun getParameters(){
        article = intent.getSerializableExtra(Constants.ARTICLE) as News
    }
    private fun bindImage(image : ImageView, url : String){

        Glide
            .with(this)
            .load(url)
            .placeholder(com.bumptech.glide.R.drawable.abc_btn_check_material_anim)
            .into(image)
    }
}