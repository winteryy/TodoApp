package com.winterry.todoapp.presenter.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.winterry.todoapp.R
import com.winterry.todoapp.databinding.ActivityMainBinding
import com.winterry.todoapp.domain.model.Todo
import com.winterry.todoapp.presenter.ui.list.TodoListAdapter
import com.winterry.todoapp.presenter.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val adapter by lazy { TodoListAdapter() }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            view = this@MainActivity
            mainRecyclerView.adapter = this@MainActivity.adapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.todoList
                .flowWithLifecycle(lifecycle, Lifecycle.State.RESUMED)
                .collectLatest {
                    binding.apply {
                        emptyTextView.isVisible = it.isEmpty()
                        mainRecyclerView.isVisible = it.isNotEmpty()
                    }
                    adapter.submitList(it)
                }
        }
    }


    fun onClickAdd(){
        startActivity(Intent(this, InputActivity::class.java))
    }
}