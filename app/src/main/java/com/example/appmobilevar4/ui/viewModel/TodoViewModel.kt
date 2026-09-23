package com.example.appmobilevar4.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.AppMobileVar4.Model.Todo
import com.example.appmobilevar4.data.RetrofitClient
import kotlinx.coroutines.launch

class TodoViewModel: ViewModel() {
    fun addTodo(
        todo: String,
        completed: Boolean,
        userId: Int,
        onResult: (Todo) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val newTodo = Todo(
                    todo = todo,
                    completed = completed,
                    userId = userId
                )

                val response = RetrofitClient.apiService.createTodo(newTodo)

                onResult(response)

            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}