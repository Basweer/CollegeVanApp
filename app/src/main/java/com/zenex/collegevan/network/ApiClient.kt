package com.zenex.collegevan.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    // PLACEHOLDER URL
    // Replace this later with your sir's actual API base URL.
    private const val BASE_URL = "https://example.com/api/"

    val apiService: ApiService by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}