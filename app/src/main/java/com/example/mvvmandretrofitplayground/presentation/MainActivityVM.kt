package com.example.mvvmandretrofitplayground.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityVM @Inject constructor() : ViewModel() {

    val x = "rtyer"
}