package com.example.rickandmortyappadventures.presenter.view

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.example.rickandmortyappadventures.R
import com.example.rickandmortyappadventures.databinding.SplashScreenFragmentBinding

class SplashScreenFragment : Fragment() {

    private lateinit var binding: SplashScreenFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SplashScreenFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSplashScreen()
    }

    private fun setupSplashScreen() {
        Handler().postDelayed({
            findNavController().navigate(R.id.action_splashScreenFragment_to_homeFragment)
        }, 2500)
    }
}