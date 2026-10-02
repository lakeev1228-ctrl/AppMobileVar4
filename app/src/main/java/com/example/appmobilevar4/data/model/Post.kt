package com.example.appmobilevar4.data.model

data class Reactions(
    val likes: Int,
    val dislikes: Int
)

data class Post(
    val id: Int,
    val title: String,
    val body: String,
    val views: Int,
    val reactions: Reactions
)