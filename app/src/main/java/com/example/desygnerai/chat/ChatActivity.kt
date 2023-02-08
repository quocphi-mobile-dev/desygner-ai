package com.example.desygnerai.chat

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desygnerai.chat.model.Message
import com.example.desygnerai.chat.model.Prompt
import com.example.desygnerai.chat.model.Text
import com.example.desygnerai.databinding.ActivityChatBinding
import com.example.desygnerai.service.API
import com.example.desygnerai.service.RetrofitHelper
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit


class ChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatBinding
    private var mMessages = ArrayList<Message>()
    private lateinit var mAdapter: ChatAdapter
    private lateinit var sendAPI: API


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAdapter = ChatAdapter(this@ChatActivity, mMessages)

        binding.rvChat.adapter = mAdapter

        val linearLayoutManager = LinearLayoutManager(this@ChatActivity)
        binding.rvChat.layoutManager = linearLayoutManager

        sendAPI = RetrofitHelper.getInstance().create(API::class.java)

        val arguments = requireNotNull(intent?.extras) {
            "Null data"
        }

        with(arguments) {
            val questionRequest = getString("question").toString()
            Log.d("questionRequest",questionRequest)
            sendQuestion(questionRequest)
        }

        binding.btnSend.setOnClickListener {
            val questionRequest = binding.textInput.text.toString()
            if (questionRequest.isNotEmpty()) {
                sendQuestion(questionRequest)
            } else {
                Toast.makeText(this@ChatActivity, "Please enter question", Toast.LENGTH_LONG).show()
            }

        }
    }


    fun sendQuestion(questionRequest: String) {
        binding.textInput.text = null
        val prompt = Prompt(questionRequest)
        val text = Text(questionRequest)
        val textSend = ArrayList<Text>()
        textSend.add(text)

        val messageSend = Message(textSend, false)
        mMessages.add(messageSend)
        mAdapter.notifyDataSetChanged()

        sendAPI.createQuestion(prompt).enqueue(
            object : retrofit2.Callback<Message> {
                override fun onResponse(call: Call<Message>, response: Response<Message>) {
                    val messageReceiver = Message(response.body()!!.messages, true)
                    mMessages.add(messageReceiver)
                    mAdapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<Message>, t: Throwable) {
                    Toast.makeText(this@ChatActivity, t.toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        )
    }
}
