package com.example.baseprojectusinghilt.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.example.api.ResultHandler
import com.example.baseprojectusinghilt.databinding.ActivityHomeBinding
import com.example.baseprojectusinghilt.viewModel.ViewModel1
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {


    private lateinit var binding: ActivityHomeBinding
    private val viewModel: ViewModel1 by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        observe()
    }

    private fun observe() {

        viewModel.demoData.observe(this) {
            when (it) {
                is ResultHandler.Success -> {

                }
                is ResultHandler.Error -> {

                }
                is ResultHandler.Loading -> {

                }
            }
        }
    }


}