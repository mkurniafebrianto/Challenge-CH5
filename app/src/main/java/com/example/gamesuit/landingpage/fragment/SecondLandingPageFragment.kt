package com.example.gamesuit.landingpage.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gamesuit.databinding.FragmentLandingPage2Binding

class SecondLandingPageFragment : Fragment() {

    private var _binding: FragmentLandingPage2Binding? = null
    private val binding: FragmentLandingPage2Binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLandingPage2Binding.inflate(layoutInflater, container, false)
        return binding.root
    }
}