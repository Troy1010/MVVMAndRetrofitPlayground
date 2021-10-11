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
    // UserIntents serve as the "input" for ViewModels. The "output" is the Presentation State and Events. All output must be observable (or immutable).
    fun userTryNavForward() {
        if (counter-- <= 0) {
            counter = 3
            navToSecondFragment.onNext(Unit)
        } else {
            // subject.onNext("Retry again $counter") is just like mutableLiveData.value = "Retry again $counter"
            showToast.onNext("Retry again $counter")
        }
    }

    // # Internal
    private var counter = 3

    // # Presentation Events
    // Subjects are very similar to MutableLiveData. They are a way to create a observable when you don't have one.
    // BehaviorSubjects are just like MutableLiveData, but PublishSubjects are different b/c they do not remember their last value, which is good for Events.
    val showToast = PublishSubject.create<String>()
    val navToSecondFragment = PublishSubject.create<Unit>()

    // # Presentation State
    val characterNames =
        futuramaRepo.characters
            .map { it.joinToString { ", ${it.name}" } }
            .toObservable() // Using Observable type so that we don't ever have to change it later
}