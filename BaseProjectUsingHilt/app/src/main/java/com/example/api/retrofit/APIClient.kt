package com.example.api.retrofit

import com.example.api.ServerBaseResponse
import com.example.baseprojectusinghilt.dataBase.Entity.DemoData
import retrofit2.Response
import retrofit2.http.GET

interface APIClient {
    @GET("products")
    suspend fun getProducts() : Response<ServerBaseResponse<List<DemoData>>>
}