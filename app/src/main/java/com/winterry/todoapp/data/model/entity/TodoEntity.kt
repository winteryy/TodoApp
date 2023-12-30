package com.winterry.todoapp.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity("Todo")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo
    var title: String,
    @ColumnInfo
    var content: String,
    @ColumnInfo
    var isChecked: Boolean
): Serializable