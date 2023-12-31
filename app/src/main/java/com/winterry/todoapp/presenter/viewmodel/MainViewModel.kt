package com.winterry.todoapp.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winterry.todoapp.domain.model.Todo
import com.winterry.todoapp.domain.usecase.TodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: TodoUseCase
) : ViewModel() {

    private val _doneEvent = MutableLiveData<Pair<Boolean, String>>()
    val doneEvent: LiveData<Pair<Boolean, String>> = _doneEvent

    val todoList = useCase.loadList()
        .stateIn(
            initialValue = emptyList(),
            started = SharingStarted.WhileSubscribed(5000),
            scope = viewModelScope
        )

    fun deleteItem(item: Todo) {
        viewModelScope.launch {
            useCase.delete(item).also {
                _doneEvent.postValue(Pair(it, "삭제 완료"))
            }
        }
    }

    fun checkItem(item: Todo) {
        viewModelScope.launch {
            useCase.update(
                item.copy(
                    isChecked = !item.isChecked
                )
            )
        }
    }
}