package com.example.desygnerai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.desygnerai.databinding.ActivityAdviceBinding

class AdviceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdviceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)


        binding = ActivityAdviceBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}