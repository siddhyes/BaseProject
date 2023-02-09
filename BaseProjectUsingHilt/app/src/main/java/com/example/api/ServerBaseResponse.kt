package com.example.api

import com.google.gson.annotations.SerializedName


data class ServerBaseResponse<T>(
    @SerializedName("status") val status: Boolean,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: T,
)