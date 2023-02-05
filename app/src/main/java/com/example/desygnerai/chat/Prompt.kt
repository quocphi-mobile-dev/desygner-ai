package com.example.desygnerai.chat

import com.google.gson.annotations.SerializedName

data class Prompt(
    @SerializedName("prompt")
    val prompt: String
)