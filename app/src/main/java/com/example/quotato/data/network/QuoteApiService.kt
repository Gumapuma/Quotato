package com.example.quotato.data.network

import com.example.quotato.data.model.Quote
import com.example.quotato.data.model.QuotesResponse
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiService {
    @GET("random")
    suspend fun getQuotes(): QuotesResponse
}
