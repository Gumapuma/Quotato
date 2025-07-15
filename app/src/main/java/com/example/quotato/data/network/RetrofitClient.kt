package com.example.quotato.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    private val retrofit: Retrofit

    init {
        val client = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://api.quotable.io/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> createService(service: Class<T>): T = retrofit.create(service)

    companion object {
        fun create(): RetrofitClient = RetrofitClient()
    }
}