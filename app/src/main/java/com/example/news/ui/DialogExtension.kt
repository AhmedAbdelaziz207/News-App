package com.example.news.ui

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import androidx.fragment.app.Fragment

fun Fragment.showDialog (
                         message : String
                         , posMessage : String? = null
                         , posAction: DialogInterface.OnClickListener? = null
                         , negMessage : String? = null
                         , negAction: DialogInterface.OnClickListener? = null

): AlertDialog {
    val dialog  = AlertDialog.Builder(context)
    dialog.setMessage(message)
    if(posAction != null ){
        dialog.setPositiveButton(posMessage,posAction )

    }
    if(negAction != null ){
        dialog.setNegativeButton(negMessage,posAction )

    }

    return dialog.show()
}
fun Activity.showDialog (
                         message : String
                         , posMessage : String? = null
                         , posAction: DialogInterface.OnClickListener? = null
                         , negMessage : String? = null
                         , negAction: DialogInterface.OnClickListener? = null

): AlertDialog {
    val dialog  = AlertDialog.Builder(this)
    dialog.setMessage(message)
    if(posAction != null ){
        dialog.setPositiveButton(posMessage,posAction )

    }
    if(negAction != null ){
        dialog.setNegativeButton(negMessage,posAction )
    }

    return dialog.show()
}