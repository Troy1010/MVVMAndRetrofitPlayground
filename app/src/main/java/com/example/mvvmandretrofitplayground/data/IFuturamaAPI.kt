package com.example.mvvmandretrofitplayground.data

import com.example.mvvmandretrofitplayground.data.model.CharactersDTOItem
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface IFuturamaAPI {
    @GET("characters")
    fun fetchCharacters(): Single<List<CharactersDTOItem>>
}