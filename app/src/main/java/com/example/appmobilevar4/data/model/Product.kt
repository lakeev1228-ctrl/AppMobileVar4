package com.example.appmobilevar4.data.model

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val tags: List<String>? = null,
    val isDeleted: Boolean? = null,
    val deletedOn: String? = null
)
