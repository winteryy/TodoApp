package com.winterry.todoapp.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("checkSet")
fun ImageView.setCheck(bool: Boolean) {
    visibility = if(bool) ImageView.VISIBLE else ImageView.INVISIBLE
}