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
import com.tminus1010.tmcommonkotlin.rx.extensions.observe
import dagger.hilt.android.AndroidEntryPoint

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
        mainActivityVM.navToSecondFragment.observe(viewLifecycleOwner) { findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment) }
        mainActivityVM.showToast.observe(viewLifecycleOwner) { Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show() }
        // # Bind Presentation State
        mainActivityVM.characterNames.observe(viewLifecycleOwner) { binding.textviewFirst.text = it }
        // # Call UserIntents
        binding.buttonFirst.setOnClickListener { mainActivityVM.userTryNavForward() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}