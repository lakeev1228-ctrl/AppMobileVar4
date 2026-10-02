package com.example.appmobilevar4.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appmobilevar4.data.model.Todo
import com.example.appmobilevar4.data.RetrofitClient
import kotlinx.coroutines.launch

class TodoViewModel: ViewModel() {
    fun addTodo(todo: Todo) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.todoApiService.createTodo(todo)

                Log.d(
                    "TodoLog",
                    "ID: ${response.id} | " +
                            "Задание: ${response.todo} | " +
                            "Отметка о завершении: ${response.completed} | " +
                            "Пользователь: ${response.userId}"
                )

            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}