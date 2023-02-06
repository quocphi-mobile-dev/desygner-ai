package com.example.desygnerai.chat

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.desygnerai.databinding.ActivityChatBinding
import com.example.desygnerai.service.API
import com.example.desygnerai.service.RetrofitHelper
import retrofit2.Call
import retrofit2.Response

class ChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatBinding
    private var mMessages = ArrayList<Message>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val sendAPI = RetrofitHelper.getInstance().create(API::class.java)
        val prompt = Prompt("Hom nay an gi")

        sendAPI.createQuestion(prompt).enqueue(

            object : retrofit2.Callback<Message> {
                override fun onResponse(
                    call: Call<Message>,
                    response: Response<Message>
                ) {
                    Toast.makeText(
                        this@ChatActivity,
                        response.message().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onFailure(call: Call<Message>, t: Throwable) {
                    Log.d("error",t.toString())
                    Toast.makeText(this@ChatActivity, t.toString(), Toast.LENGTH_LONG).show()
                }

            }
        )


    }

    fun addItem(items: String) {
//        mItems.add(item);
//        mAdapter.notifyDataSetChanged();
    }
}