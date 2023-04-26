package com.example.test.network

import com.example.test.models.GetAllPost
import com.example.test.models.GetAllPostItem
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit


var interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

var httpClientService = OkHttpClient.Builder()
    .callTimeout(2, TimeUnit.MINUTES)
    .connectTimeout(20, TimeUnit.SECONDS)
    .readTimeout(30, TimeUnit.SECONDS)
    .writeTimeout(30, TimeUnit.SECONDS)
    .addInterceptor(interceptor)

const val baseUrl = "https://jsonplaceholder.typicode.com/"
private val retrofit = Retrofit.Builder()
    .client(httpClientService.build())
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface WebService {
    @GET("posts")
    suspend fun getAllPost(): Response<ArrayList<GetAllPostItem>>
}

object TestApi {
    val webservice: WebService by lazy {
        retrofit.create(WebService::class.java)
    }
}

