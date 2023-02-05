package com.example.desygnerai.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private val client = OkHttpClient.Builder().build()

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl("http://34.130.40.208:5000/generate_completion/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

}