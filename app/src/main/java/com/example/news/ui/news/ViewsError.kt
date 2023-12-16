package com.example.news.ui.news

data class ViewsError(
    val message:String? = null,
    val throwable: Throwable?=null,
    val onTryAgainClickListener: OnTryAgainClickListener? = null
)
fun interface OnTryAgainClickListener{
    fun onTryAgainClick()
}