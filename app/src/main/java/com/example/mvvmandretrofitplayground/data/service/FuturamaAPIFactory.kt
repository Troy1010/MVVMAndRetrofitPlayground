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
            .addConverterFactory(
                MoshiConverterFactory.create( // This is how Retrofit can use Moshi to parse jsons.
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build() // Here, we are creating a moshi. Apparently it needs a KotlinJsonAdapterFactory, so we gave it one.
                )
            )
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // This is what allows us to use Single<Something> in IFuturamaAPI.
            .client(OkHttpClient.Builder().build()) // This is what Retrofit will use internally to actually make API calls.
            .build()
            .create(IFuturamaAPI::class.java)
    }
}