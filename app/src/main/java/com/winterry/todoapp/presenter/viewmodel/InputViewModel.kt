package com.winterry.todoapp.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winterry.todoapp.domain.model.Todo
import com.winterry.todoapp.domain.usecase.TodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor(
    private val useCase: TodoUseCase
): ViewModel() {

    private val _doneEvent = MutableLiveData<Pair<Boolean, String>>()
    val doneEvent: LiveData<Pair<Boolean, String>> = _doneEvent

    var title = MutableLiveData("")
    var content = MutableLiveData("")
    private var item: Todo? = null

    fun initData(item: Todo) {
        this.item = item
        title.value = item.title
        content.value = item.content
    }

    fun insertData() {
        val titleValue = title.value
        val contentValue = content.value

        if(titleValue.isNullOrBlank() || contentValue.isNullOrBlank()) {
            _doneEvent.value = Pair(false, "모든 항목을 입력해주세요.")
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            useCase.create(
                item?.copy(
                    title = titleValue, content = contentValue
                ) ?: Todo(title = titleValue, content = contentValue)
            ).also {
                _doneEvent.postValue(Pair(true, if(it) "완료" else "저장에 실패했습니다."))
            }
        }
    }
}