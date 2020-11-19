package com.example.kulinerapp.POJO

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {

    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://dev.farizdotid.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun <T> buildService(service: Class<T>): T = retrofit.create(service)
}