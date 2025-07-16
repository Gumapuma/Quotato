package com.example.quotato.data.repository

import android.util.Log
import com.example.quotato.data.model.Quote
import com.example.quotato.data.network.QuoteApiService
import com.example.quotato.data.network.RetrofitClient

class QuoteRepository {
    private val apiService = RetrofitClient.create().createService(QuoteApiService::class.java)

    suspend fun fetchRandomQuote(): Quote? {
        return try {
            val response = apiService.getQuotes()
            response.quotes.firstOrNull()
        } catch (e: Exception) {
            null
        }
    }
}
