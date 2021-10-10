package com.example.mvvmandretrofitplayground.data

import com.example.mvvmandretrofitplayground.data.model.CharactersDTO
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface IFuturamaAPI {
    @GET("/characters")
    fun fetchCharacters(s:String): Single<CharactersDTO>
}