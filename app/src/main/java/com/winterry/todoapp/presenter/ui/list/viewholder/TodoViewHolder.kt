package com.winterry.todoapp.presenter.ui.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.winterry.todoapp.databinding.ItemTodoBinding
import com.winterry.todoapp.domain.model.Todo

class TodoViewHolder(private val binding: ItemTodoBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Todo) {
        binding.item = item
    }
}