package com.winterry.todoapp.presenter.ui.list.viewholder

import android.graphics.Paint
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.winterry.todoapp.databinding.ItemTodoBinding
import com.winterry.todoapp.domain.model.Todo
import com.winterry.todoapp.presenter.ui.MainActivity
import com.winterry.todoapp.util.TextUtil.setStrikeThru
import dagger.hilt.android.qualifiers.ApplicationContext

class TodoViewHolder(
    private val binding: ItemTodoBinding,
    private val handler: MainActivity.Handler
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Todo) {
        binding.item = item
        binding.handler = handler

        binding.titleTextView.setStrikeThru(item.isChecked)
        binding.contentTextView.setStrikeThru(item.isChecked)

    }
}