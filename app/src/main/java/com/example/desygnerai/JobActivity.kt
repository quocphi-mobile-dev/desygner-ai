package com.example.desygnerai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.desygnerai.databinding.ActivityJobBinding

class JobActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJobBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)


        binding = ActivityJobBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}