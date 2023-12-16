package com.example.news.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.news.databinding.ActivitySplashBinding
import com.example.news.ui.category.NewsCategoriesActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        startCategoriesActivity()
    }

    private fun startCategoriesActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, NewsCategoriesActivity::class.java)
            startActivity(intent)
        },2000)
    }

}