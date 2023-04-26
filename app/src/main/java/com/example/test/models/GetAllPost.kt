package com.example.test.models

data class GetAllPost(
    val getAllPost: ArrayList<GetAllPostItem>
)

data class GetAllPostItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)