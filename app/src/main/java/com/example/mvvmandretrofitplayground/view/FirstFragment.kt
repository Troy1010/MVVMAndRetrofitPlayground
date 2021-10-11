package com.example.mvvmandretrofitplayground.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mvvmandretrofitplayground.R
import com.example.mvvmandretrofitplayground.databinding.FragmentFirstBinding
import com.example.mvvmandretrofitplayground.presentation.FirstFragmentVM
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class FirstFragment : Fragment() {
    private val mainActivityVM by viewModels<FirstFragmentVM>()
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var disposables = CompositeDisposable() // If you use .observe(), then you do not need this

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // # Bind Presentation Events
        mainActivityVM.navToSecondFragment
            .observeOn(AndroidSchedulers.mainThread()) // If you use .observe(), then you do not need this
            .subscribe { findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment) }
            .also { disposables += it } // If you use .observe(), then you do not need this
        mainActivityVM.showToast
            .observeOn(AndroidSchedulers.mainThread()) // If you use .observe(), then you do not need this
            .subscribe { Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show() }
            .also { disposables += it } // If you use .observe(), then you do not need this
        // # Bind Presentation State
        mainActivityVM.characterNames
            .observeOn(AndroidSchedulers.mainThread()) // If you use .observe(), then you do not need this
            .subscribe { binding.textviewFirst.text = it }
            .also { disposables += it } // If you use .observe(), then you do not need this
        // # Call UserIntents
        binding.buttonFirst.setOnClickListener { mainActivityVM.userTryNavForward() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        disposables.clear()
    }
}