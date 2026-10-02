package com.example.appmobilevar4.data.model

data class Todo(
    val id: Int? = null,
    val todo: String,
    val completed: Boolean,
    val userId: Int
)