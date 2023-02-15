package com.example.gamesuit.landingpage.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gamesuit.menupage.PageMenuActivity
import com.example.gamesuit.databinding.FragmentLandingPage3Binding
import com.example.gamesuit.intentTo

class ThirdLandingPageFragment : Fragment() {

    private var _binding: FragmentLandingPage3Binding? = null
    private val binding: FragmentLandingPage3Binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLandingPage3Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            val playerName = binding.etName.text.toString()
            context?.intentTo(PageMenuActivity::class.java) { intent ->
                intent.putExtra("name", playerName)
            }
        }
    }
}