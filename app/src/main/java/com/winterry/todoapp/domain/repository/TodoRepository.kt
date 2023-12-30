package com.winterry.todoapp.domain.repository

import com.winterry.todoapp.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    fun loadList(): Flow<List<Todo>>

    suspend fun create(item: Todo): Boolean

    suspend fun update(item: Todo): Boolean

    suspend fun delete(item: Todo): Boolean

}