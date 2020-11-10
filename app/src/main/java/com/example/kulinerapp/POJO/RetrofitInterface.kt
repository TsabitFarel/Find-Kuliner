package com.example.kulinerapp.POJO

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("api/purwakarta/kuliner")
    suspend fun topKuliner() : Response<ResponseMakanan>
}