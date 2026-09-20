package com.example.AppMobileVar4

import com.example.AppMobileVar4.Model.PostResponse
import com.example.AppMobileVar4.Model.Todo
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): PostResponse

    @POST("todos/add")
    suspend fun createTodo(@Body todo: Todo): Todo
}