package com.example.speedmeeting

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.speedmeeting.HyeongWoo.ProjectMainActivity
import com.example.speedmeeting.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setLoginUi()
    }

    private fun setLoginUi() = with(binding) {
        RegistBtn.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegistryActivity::class.java))
        }
        LoginBtn.setOnClickListener{
            startActivity(Intent(this@LoginActivity, ProjectMainActivity::class.java))
            finish()
        }
    }

}