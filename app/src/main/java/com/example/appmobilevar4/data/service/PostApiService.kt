package com.example.appmobilevar4.data.service

import com.example.appmobilevar4.data.model.PostResponse
import retrofit2.http.GET

interface PostApiService {
    @GET("posts")
    suspend fun getPosts(): PostResponse
}