package com.example.appmobilevar4.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appmobilevar4.data.RetrofitClient
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getPosts()

                for (post in response.posts) {
                    Log.d(
                        "PostLog",
                        "ID: ${post.id} | " +
                                "Заголовок: ${post.title} | " +
                                "Текст: ${post.body} | " +
                                "Реакции: ${post.reactions}"
                    )
                }
            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}