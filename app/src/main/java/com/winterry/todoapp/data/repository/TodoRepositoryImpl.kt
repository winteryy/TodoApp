package com.winterry.todoapp.data.repository

import com.winterry.todoapp.data.model.ModelMapper.toEntity
import com.winterry.todoapp.data.model.ModelMapper.toTodo
import com.winterry.todoapp.data.source.local.dao.TodoDao
import com.winterry.todoapp.domain.model.Todo
import com.winterry.todoapp.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val todoDao: TodoDao
) : TodoRepository {
    override fun loadList(): Flow<List<Todo>> {
        return flow {
            todoDao.selectAll().collect { list ->
                emit( list.map { it.toTodo() })
            }
        }
    }

    override suspend fun create(item: Todo): Boolean {
        return try {
            todoDao.insert(item.toEntity())
            true
        } catch (e: Exception) {
            false
        }

    }

    override suspend fun update(item: Todo): Boolean {
        return try {
            todoDao.insert(item.toEntity())
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun delete(item: Todo): Boolean {
        return try {
            todoDao.delete(item.toEntity())
            true
        } catch (e: Exception) {
            false
        }
    }
}