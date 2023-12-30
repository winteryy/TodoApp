package com.winterry.todoapp.data.model

import com.winterry.todoapp.data.model.entity.TodoEntity
import com.winterry.todoapp.domain.model.Todo

object ModelMapper {

    fun TodoEntity.toTodo() = Todo(
        id = id,
        title = title,
        content = content,
        isChecked = isChecked
    )

    fun Todo.toEntity() = TodoEntity(
        id = id ?:-1,
        title = title,
        content = content,
        isChecked = isChecked
    )
}