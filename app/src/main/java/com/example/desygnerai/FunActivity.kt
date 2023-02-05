package com.example.desygnerai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.desygnerai.databinding.ActivityFunBinding

class FunActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFunBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)


        binding = ActivityFunBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}