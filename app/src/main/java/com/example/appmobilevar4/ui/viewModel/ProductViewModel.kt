package com.example.appmobilevar4.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appmobilevar4.data.RetrofitClient
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    fun updateProduct() {
        viewModelScope.launch {
            try {
                val id = 48

                val productBefore = RetrofitClient.productApiService.getProduct(id)

                Log.d("RetrofitSuccess", "ID: ${productBefore.id}")
                Log.d("RetrofitSuccess", "Название: ${productBefore.title}")
                Log.d("RetrofitSuccess", "Текст: ${productBefore.description}")
                Log.d("RetrofitSuccess","Категория: ${productBefore.category}")
                Log.d("RetrofitSuccess", "Теги: ${productBefore.tags?.joinToString(", ")}")

                val post = productBefore.copy(
                    title = "Беспроводные наушники SoundWave Pro",
                    description = "Наушники с активным шумоподавлением, влагозащитой IPX4 и автономностью до 30 часов работы вместе с кейсом",
                    category = "Аудиотехника",
                    tags = listOf(
                        "Наушники, bluetooth",
                        "шумоподавление",
                        "беспроводные наушники",
                        "гаджеты"
                    )
                )

                val productAfter = RetrofitClient.productApiService.updateProduct(id, post)

                Log.d("RetrofitSuccess", "ID: ${productAfter.id}")
                Log.d("RetrofitSuccess", "Название: ${productAfter.title}")
                Log.d("RetrofitSuccess", "Текст: ${productAfter.description}")
                Log.d("RetrofitSuccess","Категория: ${productAfter.category}")
                Log.d("RetrofitSuccess", "Теги: ${productAfter.tags?.joinToString(", ")}")

            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
    fun deleteTodo() {
        viewModelScope.launch {
            val  id = 25

            try {
                val response = RetrofitClient.productApiService.deleteProduct(id = id)

                Log.d(
                    "TodoLog",
                    "ID: ${response.id} | " +
                            "Название: ${response.title} | " +
                            "Описание: ${response.description} | " +
                            "Категория: ${response.category} | " +
                            "Теги: ${response.tags} | " +
                            "Удаление: ${response.isDeleted} | " +
                            "Время удаления: ${response.deletedOn} | "
                )
            } catch (e: Exception) {
                Log.e("RetrofitError", e.message.toString())
            }
        }
    }
}