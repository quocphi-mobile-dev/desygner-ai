package com.example.desygnerai.service

import com.example.desygnerai.chat.Message
import com.example.desygnerai.chat.Prompt
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface API {
    @Headers("Content-Type: text/plain")
    @POST(".")
    fun createQuestion(@Body dataModal: Prompt): Call<Message>
}