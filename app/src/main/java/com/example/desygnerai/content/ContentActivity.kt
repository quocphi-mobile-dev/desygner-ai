package com.example.desygnerai.content

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desygnerai.R
import com.example.desygnerai.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContentBinding
    private var mQuestion = ArrayList<String>()
    private lateinit var mAdapter: QuestionAdapter
    private lateinit var mTitle: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val arguments = requireNotNull(intent?.extras) {
            "Null data"
        }

        with(arguments) {
            mQuestion = getStringArrayList("question") as ArrayList<String>
            mTitle = getString("title").toString()
            binding.tvTitle.text = mTitle
            when (mTitle) {
                getString(R.string.title_love) -> {
                    binding.layout.setBackgroundResource(R.color.red_200)
                    binding.image.setImageResource(R.drawable.ic_love)
                }
                getString(R.string.title_feelings) -> {
                    binding.layout.setBackgroundResource(R.color.blue_200)
                    binding.image.setImageResource(R.drawable.ic_feeling)
                }
                getString(R.string.title_fun) -> {
                    binding.layout.setBackgroundResource(R.color.red_400)
                    binding.image.setImageResource(R.drawable.ic_fun)
                }
                getString(R.string.title_communication) -> {
                    binding.layout.setBackgroundResource(R.color.grey_700)
                    binding.image.setImageResource(R.drawable.ic_communication)
                }
                getString(R.string.title_study) -> {
                    binding.layout.setBackgroundResource(R.color.teal_900)
                    binding.image.setImageResource(R.drawable.ic_study)
                }
                getString(R.string.title_job) -> {
                    binding.layout.setBackgroundResource(R.color.green_200)
                    binding.image.setImageResource(R.drawable.ic_job)
                }
                getString(R.string.title_advice) -> {
                    binding.layout.setBackgroundResource(R.color.yellow_200)
                    binding.image.setImageResource(R.drawable.ic_advice)
                }
                getString(R.string.title_food) -> {
                    binding.layout.setBackgroundResource(R.color.orange_200)
                    binding.image.setImageResource(R.drawable.ic_food)
                }
            }

        }


        mAdapter = QuestionAdapter(this@ContentActivity, mQuestion)

        binding.rvQuestion.adapter = mAdapter
        binding.rvQuestion.isNestedScrollingEnabled = false

        val linearLayoutManager = LinearLayoutManager(this@ContentActivity)
        binding.rvQuestion.layoutManager = linearLayoutManager
    }

}