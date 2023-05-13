package com.example.speedmeeting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.speedmeeting.databinding.ActivityRegistBinding

class RegistryActivity : AppCompatActivity() {
    lateinit var binding :ActivityRegistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRegistryUi()
    }

    private fun setRegistryUi() = with(binding) {
        registBtn.setOnClickListener{
            finish()
        }
    }
}