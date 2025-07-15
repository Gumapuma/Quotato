package com.example.quotato.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotato.data.model.Quote
import com.example.quotato.data.repository.QuoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QuoteViewModel(
    private val repository: QuoteRepository
) : ViewModel() {

    private val _quote = MutableStateFlow<Quote?>(null)
    val quote: StateFlow<Quote?> = _quote

    fun loadQuote() {
        viewModelScope.launch {
            val result = repository.fetchRandomQuote()
            _quote.value = result
        }
    }

    init {
        loadQuote()
    }
}