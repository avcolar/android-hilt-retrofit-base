package com.example.basecodes.data.api

import retrofit2.Response

class ApiRepositoryImpl : ApiService {


    override suspend fun <T> getDataList(): Response<List<T>> {
        TODO("Not yet implemented")
    }


}