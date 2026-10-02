package com.example.appmobilevar4.data.service

import com.example.appmobilevar4.data.model.Product
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ProductApiService {
    @GET("product/{id}")
    suspend fun getProduct(@Path("id") id: Int): Product

    @PUT("product/{id}")
    suspend fun updateProduct(@Path("id") id: Int, @Body product: Product): Product

    @DELETE("product/{id}")
    suspend fun deleteProduct(@Path("id") id: Int): Product
}