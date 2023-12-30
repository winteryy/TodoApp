package com.winterry.todoapp.domain.usecase

import com.winterry.todoapp.domain.model.Todo
import com.winterry.todoapp.domain.repository.TodoRepository
import javax.inject.Inject

class TodoUseCase @Inject constructor(
    private val todoRepository: TodoRepository
) {

    fun loadList() = todoRepository.loadList()

    suspend fun create(item: Todo) = todoRepository.create(item)

    suspend fun update(item: Todo) = todoRepository.update(item)

    suspend fun delete(item: Todo) = todoRepository.delete(item)

}