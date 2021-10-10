package com.example.mvvmandretrofitplayground.data

import org.junit.Test
import java.util.concurrent.TimeUnit

class FuturamaAPITest {
    @Test
    fun test() {
        // # Given
        val futuramaAPI = FuturamaAPIFactory().createFuturamaAPI()
        // # When
        futuramaAPI.fetchCharacters()
            // # Then
            .doOnError { println("error:$it") }
            .doOnSuccess { println("result:$it") }
            .test()
            .apply { await(5, TimeUnit.SECONDS) }
    }
}