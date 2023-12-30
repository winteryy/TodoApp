package com.winterry.todoapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.winterry.todoapp.data.model.entity.TodoEntity
import com.winterry.todoapp.data.source.local.dao.TodoDao

@Database(entities = [TodoEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun todoDao(): TodoDao
}