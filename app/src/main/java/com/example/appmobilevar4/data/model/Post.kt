package com.example.AppMobileVar4.Model

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