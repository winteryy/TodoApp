package com.winterry.todoapp.presenter.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.winterry.todoapp.databinding.ActivityInputBinding
import com.winterry.todoapp.presenter.viewmodel.InputViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputActivity: AppCompatActivity() {

    private lateinit var binding: ActivityInputBinding

    private val viewModel: InputViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater).apply {
            setContentView(root)
            lifecycleOwner = this@InputActivity
            viewModel = this@InputActivity.viewModel
        }

        observeViewModel()
        setOnClickBackButton()
    }

    private fun setOnClickBackButton() {
        binding.backButton.setOnClickListener {
            finish()
        }
    }

    private fun observeViewModel() {
        viewModel.doneEvent.observe(this) {
            Toast.makeText(this, it.second, Toast.LENGTH_SHORT).show()
            if(it.first) {
                finish()
            }
        }
    }
}