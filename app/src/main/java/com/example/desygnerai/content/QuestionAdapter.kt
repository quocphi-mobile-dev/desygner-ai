package com.example.desygnerai.content

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.desygnerai.R
import com.example.desygnerai.chat.ChatActivity

class QuestionAdapter(context: Context, questions: List<String>) :
    RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    private var mQuestions: List<String>
    private var mContext: Context

    fun questionAdapter(context: Context, questions: List<String>) {
        mQuestions = questions
        mContext = context
    }

    init {
        mQuestions = questions
        mContext = context
    }

    override fun getItemCount(): Int {
        return mQuestions.size
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val contactView: View =
            inflater.inflate(R.layout.item_question, parent, false)
        return ContentQuestion(contactView, mContext)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = mQuestions[position]
        holder.bindMessage(question)
    }

    abstract class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bindMessage(question: String?)
    }


    class ContentQuestion(itemView: View, var context: Context) :
        QuestionViewHolder(itemView) {
        var body: TextView

        init {
            body = itemView.findViewById<View>(R.id.tvQuestion) as TextView
        }

        override fun bindMessage(question: String?) {
            body.text = question
            body.setOnClickListener {
                val intent = Intent(context, ChatActivity::class.java)
                intent.putExtra("question", question)
                context.startActivity(intent)
            }
        }
    }
}

