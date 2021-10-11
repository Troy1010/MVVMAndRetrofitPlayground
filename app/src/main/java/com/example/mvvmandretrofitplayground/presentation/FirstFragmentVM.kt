package com.example.mvvmandretrofitplayground.presentation

import androidx.lifecycle.ViewModel
import com.example.mvvmandretrofitplayground.data.repo.FuturamaRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

@HiltViewModel
class FirstFragmentVM @Inject constructor(
    futuramaRepo: FuturamaRepo
) : ViewModel() {
    // # UserIntents
    // View Events are stuff like onClick, onLongClick, onSwipe, etc
    // UserIntents are basically more specific view events, which represent what the user was trying to do.
    // UserIntents serve as the "input" for ViewModels. The "output" is the Presentation State and Events.
    fun userTryNavForward() {
        if ((counter--) <= 0) {
            counter = 3
            navToSecondFragment.onNext(Unit)
        } else {
            // OnNext() causes the observable to emit. It's just like mutableLiveData.value = "Retry again $counter"
            toast.onNext("Retry again $counter")
        }
    }

    // # Internal
    private var counter = 3

    // # Presentation Events
    // Subjects are a way to create observables when you don't have one
    val toast = PublishSubject.create<String>()
    val navToSecondFragment = PublishSubject.create<Unit>()

    // # Presentation State
    val characterNames =
        futuramaRepo.getCharacters()
            .map { it.joinToString { ", ${it.name}" } }
            .toObservable() // Using Observable type so that we don't ever have to change it later
}