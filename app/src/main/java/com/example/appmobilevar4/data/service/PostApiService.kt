package com.example.appmobilevar4.data.service

import com.example.AppMobileVar4.Model.PostResponse
import retrofit2.http.GET

interface PostApiService {
    @GET("posts")
    suspend fun getPosts(): PostResponse
}