package com.example.quotato.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotato.data.model.Quote
import com.example.quotato.data.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QuoteViewModel(
    private val repository: QuoteRepository
) : ViewModel() {

    private val _quote = MutableStateFlow<Quote?>(null)
    val quote: StateFlow<Quote?> = _quote

    init {
        loadQuote()
    }

    fun loadQuote() {
        viewModelScope.launch {
            val newQuote = repository.fetchRandomQuote()
            val sanitized = newQuote?.copy(
                author = if (newQuote.author.equals("null", ignoreCase = true)) "Unknown author" else newQuote.author
            )
            _quote.value = sanitized
        }
    }
}

