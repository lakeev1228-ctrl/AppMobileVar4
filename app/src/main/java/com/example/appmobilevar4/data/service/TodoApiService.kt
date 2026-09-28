package com.example.appmobilevar4.data.service

import com.example.AppMobileVar4.Model.Todo
import retrofit2.http.Body
import retrofit2.http.POST

interface TodoApiService {
    @POST("todos/add")
    suspend fun createTodo(@Body todo: Todo): Todo
}