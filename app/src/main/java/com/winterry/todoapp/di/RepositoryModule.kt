package com.winterry.todoapp.di

import com.winterry.todoapp.data.repository.TodoRepositoryImpl
import com.winterry.todoapp.data.source.local.dao.TodoDao
import com.winterry.todoapp.domain.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providesTodoRepository(
        todoDao: TodoDao,
    ): TodoRepository = TodoRepositoryImpl(todoDao)

}