package com.example.quotato.data.repository

import com.example.quotato.data.model.Quote
import com.example.quotato.data.network.QuoteApiService

class QuoteRepository(
    private val apiService: QuoteApiService
) {
    suspend fun fetchRandomQuote(): Quote = apiService.getRandomQuote()
}