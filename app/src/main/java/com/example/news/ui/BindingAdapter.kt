package com.example.news.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("url")
fun bindImage(image : ImageView, url : String){

    Glide.with(image)
        .load(url)
        .placeholder(com.bumptech.glide.R.drawable.abc_btn_check_material_anim)
        .into(image)
}

