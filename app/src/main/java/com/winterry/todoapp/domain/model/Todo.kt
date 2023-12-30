package com.winterry.todoapp.domain.model

import java.io.Serializable

data class Todo(
    val id: Int = 0,
    val title: String,
    val content: String,
    val isChecked: Boolean = false,
): Serializable
