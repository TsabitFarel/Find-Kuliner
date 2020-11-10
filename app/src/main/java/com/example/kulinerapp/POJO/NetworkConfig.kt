package com.example.kulinerapp.POJO

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object NetworkConfig {

    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://dev.farizdotid.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun <T> buildService(service: Class<T>): T = retrofit.create(service)
}