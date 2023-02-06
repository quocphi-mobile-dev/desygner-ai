package com.example.desygnerai.home

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.desygnerai.*
import com.example.desygnerai.chat.ChatActivity
import com.example.desygnerai.databinding.ActivityScrollingBinding


class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ask.categoryAsk.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }

        binding.love.categoryLove.setOnClickListener {
            val intent = Intent(this, LoveActivity::class.java)
            startActivity(intent)
        }

        binding.felling.categoryFelling.setOnClickListener {
            val intent = Intent(this, FeelingActivity::class.java)
            startActivity(intent)
        }

        binding.`fun`.categoryFun
            .setOnClickListener {
                val intent = Intent(this, FunActivity::class.java)
                startActivity(intent)
            }

        binding.communication.categoryCommunication.setOnClickListener {
            val intent = Intent(this, CommunicationActivity::class.java)
            startActivity(intent)
        }

        binding.study.categoryStudy.setOnClickListener {
            val intent = Intent(this, StudyActivity::class.java)
            startActivity(intent)
        }

        binding.job.categoryJob.setOnClickListener {
            val intent = Intent(this, JobActivity::class.java)
            startActivity(intent)
        }

        binding.advice.categoryAdvice.setOnClickListener {
            val intent = Intent(this, AdviceActivity::class.java)
            startActivity(intent)
        }

        binding.food.categoryFood.setOnClickListener {
            val intent = Intent(this, FoodActivity::class.java)
            startActivity(intent)
        }
    }
}