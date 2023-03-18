package com.example.speedmeeting

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.speedmeeting.HyeongWoo.ProjectMainActivity
import com.example.speedmeeting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Homebutton.setOnClickListener {
            val intent = Intent(this@MainActivity, ProjectMainActivity::class.java)
            startActivity(intent)
        }
    }
}