package com.example.quotato.data.model

import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("_id") val id: String,
    @SerializedName("content") val content: String,
    @SerializedName("author") val author: String
)