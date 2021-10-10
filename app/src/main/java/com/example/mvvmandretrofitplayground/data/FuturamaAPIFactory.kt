package com.example.mvvmandretrofitplayground.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit


class FuturamaAPIFactory {
    fun createFuturamaAPI(): IFuturamaAPI {
        return Retrofit.Builder()
            .baseUrl("https://api.sampleapis.com/futurama")
            .client(OkHttpClient.Builder().build())
            .build()
            .create(IFuturamaAPI::class.java)
    }
}