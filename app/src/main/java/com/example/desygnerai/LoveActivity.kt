package com.example.desygnerai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.desygnerai.databinding.ActivityLoveBinding

class LoveActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)


        binding = ActivityLoveBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}