package com.example.rickandmortyappadventures.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.rickandmortyappadventures.R
import com.example.rickandmortyappadventures.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        MainActivityBinding.inflate(layoutInflater)
    }
    private val controller by lazy {
        findNavController(R.id.activity_main_navHost)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        if (controller.currentDestination?.id != R.id.homeFragment) {
            super.onBackPressed()
        }
    }
}

