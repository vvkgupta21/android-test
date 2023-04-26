package com.example.test.repository

import com.example.test.network.TestApi

class Repository(private val service: TestApi) {

    suspend fun getAllPost() = service.webservice.getAllPost()
}