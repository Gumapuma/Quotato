package com.example.quotato.data.model

import com.google.gson.annotations.SerializedName

data class QuotesResponse(
    @SerializedName("Quotes")
    val quotes: List<Quote>
)
