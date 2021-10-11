package com.example.mvvmandretrofitplayground.data.service

import com.example.mvvmandretrofitplayground.data.model.CharacterDTO
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface IFuturamaAPI {
    @GET("characters")
    fun fetchCharacters(): Single<List<CharacterDTO>>
}