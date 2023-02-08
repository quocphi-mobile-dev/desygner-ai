package com.example.desygnerai.chat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desygnerai.R
import com.example.desygnerai.chat.model.Message


class ChatAdapter(context: Context, messages: List<Message>) :
    RecyclerView.Adapter<ChatAdapter.MessageViewHolder>() {

    private val MESSAGE_OUTGOING = 123
    private val MESSAGE_INCOMING = 321


    private var mMessages: List<Message>
    private var mContext: Context

    fun chatAdapter(context: Context, messages: List<Message>) {
        mMessages = messages
        mContext = context
    }

    override fun getItemCount(): Int {
        return mMessages.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (mMessages[position].inComing) {

            MESSAGE_OUTGOING
        } else {
            MESSAGE_INCOMING
        }
    }


    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        return when (viewType) {
            MESSAGE_INCOMING -> {
                val contactView: View =
                    inflater.inflate(R.layout.message_incoming, parent, false)
                IncomingMessageViewHolder(contactView)
            }
            MESSAGE_OUTGOING -> {
                val contactView: View =
                    inflater.inflate(R.layout.message_outgoing, parent, false)
                OutgoingMessageViewHolder(contactView)
            }
            else -> {
                throw IllegalArgumentException("Unknown view type")
            }
        }
    }


    abstract class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bindMessage(message: Message?)
    }

    init {
        mMessages = messages
        mContext = context
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = mMessages[position]
        holder.bindMessage(message)
    }

    class IncomingMessageViewHolder(itemView: View) :
        MessageViewHolder(itemView) {
        var body: TextView
        override fun bindMessage(message: Message?) {
            body.text = message!!.messages[0].text
        }

        init {
            body = itemView.findViewById<View>(R.id.tvBody) as TextView
        }
    }

    class OutgoingMessageViewHolder(itemView: View) :
        MessageViewHolder(itemView) {
        var body: TextView
        override fun bindMessage(message: Message?) {
            body.text = message!!.messages[0].text
        }

        init {
            body = itemView.findViewById<View>(R.id.tvBody) as TextView
        }
    }
}
