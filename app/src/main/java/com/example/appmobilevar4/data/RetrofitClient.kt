package com.example.appmobilevar4.data

import com.example.appmobilevar4.data.service.PostApiService
import com.example.appmobilevar4.data.service.TodoApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy

object RetrofitClient {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.59", 3128))

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .proxy(proxy)
        .build()

    val RetrofitClient =
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val postApiService: PostApiService by lazy {
        RetrofitClient
            .create(PostApiService::class.java)
    }
    val todoApiService: TodoApiService by lazy {
        RetrofitClient
            .create(TodoApiService::class.java)
    }
}