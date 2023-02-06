package com.example.desygnerai.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private val client = OkHttpClient.Builder()
        .readTimeout(5, TimeUnit.MINUTES)
        .writeTimeout(5, TimeUnit.MINUTES)
        .build()

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl("http://34.130.40.208:5000/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

}