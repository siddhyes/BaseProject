package com.example.api

import retrofit2.Response

suspend fun <T : Any> runIO(work: suspend () -> Response<ServerBaseResponse<T>>): ResultHandler<ServerBaseResponse<T>> {
    return try {
        val response = work.invoke()
        if (response.isSuccessful) {
            val result = response.body() as ServerBaseResponse<T>
            if (result != null) {
                ResultHandler.Success(result)
            } else {
                ResultHandler.Error("Result is null")
            }

        } else {
            ResultHandler.Error("Result is null")
        }
    } catch (e: Exception) {
        ResultHandler.Error(e.toString())
    }
}

sealed class ResultHandler<K>() {
    data class Success<K>(val da: K?=null) : ResultHandler<K>()
    data class Error<K>(val error: String?=null) : ResultHandler<K>()
     class Loading<K>:ResultHandler<K>()
}
