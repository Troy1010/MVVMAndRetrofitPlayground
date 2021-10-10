package com.example.mvvmandretrofitplayground.data.service

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject


class FuturamaAPIFactory @Inject constructor() {
    fun createFuturamaAPI(): IFuturamaAPI {
        return Retrofit.Builder()
            .baseUrl("https://api.sampleapis.com/futurama/")
            .addConverterFactory(MoshiConverterFactory.create(
                Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            ))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(IFuturamaAPI::class.java)
    }
}