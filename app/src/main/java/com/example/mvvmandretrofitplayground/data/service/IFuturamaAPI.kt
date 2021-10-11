package com.example.mvvmandretrofitplayground.data.service

import com.example.mvvmandretrofitplayground.data.model.CharacterDTO
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface IFuturamaAPI {
    // Retrofit has a lot more annotations that you can use, like @Headers and @Body.
    // They're all listed out here: https://square.github.io/retrofit/
    @GET("characters")
    fun fetchCharacters(): Single<List<CharacterDTO>>
}