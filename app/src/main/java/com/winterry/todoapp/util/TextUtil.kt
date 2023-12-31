package com.winterry.todoapp.util

import android.graphics.Paint
import android.widget.TextView

object TextUtil {
    fun TextView.setStrikeThru(bool: Boolean) {
        paintFlags = if(bool) {
            Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            0
        }
    }
}