package com.example.mvvmandretrofitplayground.presentation

import androidx.lifecycle.ViewModel
import com.example.mvvmandretrofitplayground.data.repo.FuturamaRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityVM @Inject constructor(
    futuramaRepo: FuturamaRepo
) : ViewModel() {
    val characterNames =
        futuramaRepo.getCharacters()
            .map { it.joinToString { ", ${it.name}" } }
            .toObservable() // Using Observable type so that we don't ever have to change it later
    val x = "rtyer"
}