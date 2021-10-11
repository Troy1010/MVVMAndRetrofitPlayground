package com.example.mvvmandretrofitplayground.data.repo

import com.example.mvvmandretrofitplayground.data.service.FuturamaAPIFactory
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FuturamaRepo @Inject constructor(futuramaAPIFactory: FuturamaAPIFactory) {
    private val futuramaApi = futuramaAPIFactory.createFuturamaAPI()
    val characters =
        futuramaApi.fetchCharacters()
            .subscribeOn(Schedulers.io())
            .cache()
}