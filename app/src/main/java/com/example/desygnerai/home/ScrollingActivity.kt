package com.example.desygnerai.home

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.desygnerai.*
import com.example.desygnerai.chat.ChatActivity
import com.example.desygnerai.content.ContentActivity
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
            intent.putExtra("question", "empty")
            startActivity(intent)
        }

        binding.love.categoryLove.setOnClickListener {
            val intent = Intent(this, ContentActivity::class.java)
            intent.putExtra("title", getString(R.string.title_love))
            val values: Array<String> = resources.getStringArray(R.array.love)
            val mQuestion = ArrayList<String>()
            for (item in values) {
                mQuestion.add(item)
            }
            intent.putExtra("question", mQuestion)
            startActivity(intent)
        }

        binding.felling.categoryFelling.setOnClickListener {
            val intent = Intent(this, ContentActivity::class.java)
            intent.putExtra("title", getString(R.string.title_feelings))
            val values: Array<String> = resources.getStringArray(R.array.feeling)
            val mQuestion = ArrayList<String>()
            for (item in values) {
                mQuestion.add(item)
            }
            intent.putExtra("question", mQuestion)
            startActivity(intent)
        }

        binding.`fun`.categoryFun
            .setOnClickListener {
                val intent = Intent(this, ContentActivity::class.java)
                intent.putExtra("title", getString(R.string.title_fun))
                val values: Array<String> = resources.getStringArray(R.array.`fun`)
                val mQuestion = ArrayList<String>()
                for (item in values) {
                    mQuestion.add(item)
                }
                intent.putExtra("question", mQuestion)
                startActivity(intent)
            }

        binding.communication.categoryCommunication.setOnClickListener {
            val intent = Intent(this, ContentActivity::class.java)
            intent.putExtra("title", getString(R.string.title_communication))
            val values: Array<String> = resources.getStringArray(R.array.communication)
            val mQuestion = ArrayList<String>()
            for (item in values) {
                mQuestion.add(item)
            }
            intent.putExtra("question", mQuestion)
            startActivity(intent)
        }

        binding.study.categoryStudy.setOnClickListener {
            val intent = Intent(this, ContentActivity::class.java)
            intent.putExtra("title", getString(R.string.title_study))
            val values: Array<String> = resources.getStringArray(R.array.study)
            val mQuestion = ArrayList<String>()
            for (item in values) {
                mQuestion.add(item)
            }
            intent.putExtra("question", mQuestion)
            startActivity(intent)
        }

        binding.job.categoryJob.setOnClickListener {
            val intent = Intent(this, ContentActivity::class.java)
            intent.putExtra("title", getString(R.string.title_job))
            val values: Array<String> = resources.getStringArray(R.array.job)
            val mQuestion = ArrayList<String>()
            for (item in values) {
                mQuestion.add(item)
            }
            intent.putExtra("question", mQuestion)
            startActivity(intent)
        }

        binding.advice.categoryAdvice.setOnClickListener {
            val intent = Intent(this, ContentActivity::class.java)
            intent.putExtra("title", getString(R.string.title_advice))
            val values: Array<String> = resources.getStringArray(R.array.advice)
            val mQuestion = ArrayList<String>()
            for (item in values) {
                mQuestion.add(item)
            }
            intent.putExtra("question", mQuestion)
            startActivity(intent)
        }

        binding.food.categoryFood.setOnClickListener {
            val intent = Intent(this, ContentActivity::class.java)
            intent.putExtra("title", getString(R.string.title_food))
            val values: Array<String> = resources.getStringArray(R.array.food)
            val mQuestion = ArrayList<String>()
            for (item in values) {
                mQuestion.add(item)
            }
            intent.putExtra("question", mQuestion)
            startActivity(intent)
        }
    }
}