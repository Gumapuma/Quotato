package com.example.quotato.data.network

import com.example.quotato.data.model.Quote
import retrofit2.http.GET

interface QuoteApiService {
    @GET("random")
    suspend fun getRandomQuote(): Quote
}