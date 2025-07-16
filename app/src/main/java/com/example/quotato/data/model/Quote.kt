package com.example.quotato.data.model

import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("quote")
    val content: String,

    @SerializedName("author")
    val author: String
)


