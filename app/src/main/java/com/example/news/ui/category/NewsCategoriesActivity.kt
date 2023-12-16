package com.example.news.ui.category

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.news.databinding.ActivityNewsCategoriesBinding
import com.example.news.ui.Constants
import com.example.news.ui.home.HomeActivity

class NewsCategoriesActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityNewsCategoriesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityNewsCategoriesBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.sportCategory.setOnClickListener{
            openNewsForCategory("Sports")
        }
        viewBinding.healthCategory.setOnClickListener{
            openNewsForCategory("Health")
        }
        viewBinding.businessCategory.setOnClickListener{
            openNewsForCategory("Business")
        }

        viewBinding.scienceCategory.setOnClickListener{
            openNewsForCategory("Science")
        }
        viewBinding.environmentCategory.setOnClickListener{
            openNewsForCategory("entertainment")
        }
    }

    private fun openNewsForCategory(categoryName : String) {
        val intent  = Intent(this ,HomeActivity::class.java)
        intent.putExtra(Constants.CATEGORY_NAME , categoryName)
        startActivity(intent)
    }


}