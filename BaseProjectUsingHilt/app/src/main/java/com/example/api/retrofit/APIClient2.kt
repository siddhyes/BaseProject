package com.example.api.retrofit

import com.example.baseprojectusinghilt.dataBase.Entity.DemoData
import retrofit2.Response
import retrofit2.http.GET

interface APIClient2 {

    @GET("products")
    suspend fun getProducts() : Response<List<DemoData>>
}