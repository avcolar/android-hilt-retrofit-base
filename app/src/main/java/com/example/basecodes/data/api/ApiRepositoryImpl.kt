package com.example.basecodes.data.api

import retrofit2.Response
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun <T> getDataList(): Response<List<T>> = apiService.getDataList()

}