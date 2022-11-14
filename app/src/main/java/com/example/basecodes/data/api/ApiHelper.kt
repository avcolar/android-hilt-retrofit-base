package com.example.basecodes.data.api

import retrofit2.Response

interface ApiHelper {

    suspend fun <T> getDataList(): Response<List<T>>
}