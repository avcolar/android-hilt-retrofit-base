package com.example.basecodes.data.api

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("")
    suspend fun <T> getDataList(): Response<List<T>>
}