package com.example.basecodes.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.basecodes.di.viewmodels.ApiViewModel
import com.example.basecodes.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val apiViewModel: ApiViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupObserver()
    }

    private fun setupObserver() {
        apiViewModel.data.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    // TODO render
                }
                Status.LOADING -> {
                    // TODO show loading
                }
                Status.ERROR -> {
                    // TODO show error
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
        )
    }


}