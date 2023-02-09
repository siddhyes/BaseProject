package com.example.baseprojectusinghilt.repo

import com.example.api.ResultHandler.Loading
import com.example.api.retrofit.APIClient
import com.example.api.runIO
import com.example.baseprojectusinghilt.dataBase.AppDataBase
import com.example.baseprojectusinghilt.utils.SpUtil
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Repo1 @Inject constructor(
    private val dataBase: AppDataBase,
    private val apiClient: APIClient,
    private val sf: SpUtil
) {




    fun getProduct() = flow {
        emit(Loading())
        emit(runIO { apiClient.getProducts() })
    }
}