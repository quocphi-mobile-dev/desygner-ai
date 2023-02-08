package com.example.desygnerai.chat.model

import com.google.gson.annotations.SerializedName

class Message(
    @SerializedName("messages")
    val messages: List<Text>,
    val inComing: Boolean
)