package com.example.desygnerai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.desygnerai.databinding.ActivityFeelingBinding

class FeelingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFeelingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding = ActivityFeelingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}