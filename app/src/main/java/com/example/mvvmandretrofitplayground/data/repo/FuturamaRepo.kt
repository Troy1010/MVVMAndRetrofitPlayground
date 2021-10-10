package com.example.mvvmandretrofitplayground.data.repo

import com.example.mvvmandretrofitplayground.data.model.CharactersDTOItem
import com.example.mvvmandretrofitplayground.data.service.FuturamaAPIFactory
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class FuturamaRepo @Inject constructor(futuramaAPIFactory: FuturamaAPIFactory) {
    private val futuramaApi = futuramaAPIFactory.createFuturamaAPI()
    fun getCharacters(): Single<List<CharactersDTOItem>> {
        return futuramaApi.fetchCharacters()
            .subscribeOn(Schedulers.io())
    }
}